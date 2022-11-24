package com.ssafy.Whereismyhouse.user.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.Whereismyhouse.user.model.dto.User;
import com.ssafy.Whereismyhouse.user.model.dto.UserLogin;
import com.ssafy.Whereismyhouse.user.model.dto.UserLoginResponse;
import com.ssafy.Whereismyhouse.user.model.dto.UserLogoutRequest;
import com.ssafy.Whereismyhouse.user.model.dto.UserModifyRequest;
import com.ssafy.Whereismyhouse.user.model.service.UserService;
import com.ssafy.Whereismyhouse.util.JwtServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int REFRESH_TOKEN_EXPIRE_MINUTES = 2; // 주단위
	private static final int REFRESH_TOKEN_EXPIRE_TIME = 1000 * 30 * REFRESH_TOKEN_EXPIRE_MINUTES;
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private UserService userService;
    

//
//	
//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//		String action = request.getServletPath();
//		System.out.println("action..." + action);
//		String path = "index.jsp";
//		
//		try {
//
//			switch (action) {
//			case "/join.user":
//				path = join(request, response);
////				redirect(request, response, path);
//				break;
//			case "/emailcheck.user":
//				int cnt = emailcheck(request, response);
//				System.out.println(cnt);
//				response.setContentType("text/plain;charset=utf-8");
//				PrintWriter out = response.getWriter();
//				out.println(cnt);
//				path = "fetching";
//				break;
//			case "/login.user":
//				path = login(request, response);
//				break;
//			case "/logout.user":
//				path = logout(request, response);
//				break;
//			case "/update.user":
//				path = update(request, response);
//				break;
//			case "/delete.user":
//				path = delete(request, response);
//				break;
//			default:
//				break;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			path = "error/error.jsp";
//		}
//		
//		System.out.println("path..." + path);
//		if (path.startsWith("redirect:")) {
//			System.out.println("redirect....");
//			response.sendRedirect(path.substring(9));
//		} else if (path == "fetching") {
//			System.out.println("fetching");
//		} else {
//			request.getRequestDispatcher(path).forward(request, response);			
//		}
//	}

	@PostMapping("delete")
	private ResponseEntity<?> delete(HttpServletRequest request, @RequestBody UserModifyRequest dto, HttpServletResponse response) throws SQLException {
		String email = dto.getEmail();
		String pwd = dto.getPassword();
		System.out.println("delete..." + email + ", " + pwd);
		int res = userService.delete(email, pwd);
		System.out.println(res);
		
		HttpSession session = request.getSession();
		session.invalidate();
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
		//return "redirect:../";
	}


//	private String update(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//
//		HttpSession session = request.getSession();
//		
//		String name = request.getParameter("name");
//		String email = ((User) session.getAttribute("userInfo")).getEmail();
//		String pwd = request.getParameter("pwd");
//
//		User user = new User(email, name, password, user);
//
//		session.setAttribute("userInfo", user);
//		String referer = request.getHeader("referer");
//		System.out.println(referer);
//
//		userService.update(user);
//		
//		return "redirect:user/profile";
//	}

	
	@GetMapping("/profile")
	private String profile(HttpServletRequest request, Model model) throws SQLException {
		return "user/profile";
	}
	
	@GetMapping("/update_profile")
	private String profileForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("update_profile....");
		return "user/update_profile";
	}
	
	@PostMapping("/modifyProfile")
	private ResponseEntity<?> modifyProfile(HttpServletRequest request, @RequestBody UserModifyRequest dto, HttpServletResponse response) throws SQLException, MalformedJwtException, SignatureException, UnsupportedEncodingException {
	    System.out.println("프로필 수정...");
		
		
		HttpSession session = request.getSession();

	    
	  /* 
	    // jwt access 토큰이 유효한지 아닌지 검사합니다.
	    // 유효하다면 변경 작업을 그대로 수행하고,
	    // 유효하지 않다면 해당 이메일로 redis의 리프레시 토큰이 있는지 검사,
	    		// 리프레시 토큰이 유효한 경우 ->  액세스 토큰을 재발급
	    		// 리프레시 토큰이 유효하지 않으면 액세스 토큰과 refresh 토큰을 재발급
	    
	  */  
	    User user = new User(dto.getEmail(), dto.getName(), dto.getPassword(), dto.getUserKind());

	    
	    
	    String accessToken = (String) session.getAttribute("access-token");
		// 1. Access Token 검증
        if (!jwtService.validateToken(accessToken)) {
        	System.out.println();
            // 유효하지 않은 access token인 경우 액세스 토큰과 refresh 토큰을 재발급
        	System.out.println("유효하지 않은 access token인 경우 액세스 토큰을 재발급");
        	
            if (redisTemplate.opsForValue().get("RT:" + user.getEmail())
            		!= null) {
            	//재발급 성공
            	accessToken = jwtService.createAccessToken("userid", user.getEmail());// key, data  
    	    	session.setAttribute("access-token", accessToken);
            } else { // refresh token이 만기되었으므로 다시 로그인해야함
            	return new ResponseEntity<String>("세션이 만료되었습니다. 다시 로그인 해 주세요.", HttpStatus.OK);
            }
			
			
			
			
			
			
			//String refreshToken = jwtService.createRefreshToken("userid", user.getEmail());// key, data
			
//			redisTemplate.opsForValue()
  //          .set("RT:" + user.getEmail(), refreshToken, REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
			
        }
	    
	    	session = request.getSession();
	    	session.setAttribute("userInfo", user);

	
		    userService.update(user);
		    System.out.println("modifyProfile....");
		    String referer = request.getHeader("referer");
		    System.out.println(referer);
		    return new ResponseEntity<String>("success", HttpStatus.OK);
	    

		
	   //return "redirect:/user/profile";

	}

	@PostMapping("/login")
	private  ResponseEntity<?> login(HttpServletRequest request, @RequestBody UserLogin dto) throws SQLException {
		logger.info(dto.toString());
		User user = userService.login(dto.getEmail(), dto.getPassword());
		System.out.println(dto.getEmail() +" " + dto.getPassword() + " " + user);

		if (user != null) {		//login success
			String accessToken = jwtService.createAccessToken("userid", user.getEmail());// key, data
			String refreshToken = jwtService.createRefreshToken("userid", user.getEmail());// key, data
			
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			session.setAttribute("access-token", accessToken);
			System.out.println("로그인후 세션 정보 저장..." + session.getAttribute("userInfo"));
			redisTemplate.opsForValue()
            .set("RT:" + dto.getEmail(), refreshToken, REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
			
			System.out.println("time...:" + REFRESH_TOKEN_EXPIRE_TIME );
			//session.setAttribute("refresh-token", refreshToken);
			
			System.out.println("login 성공... access token : " + accessToken);
			System.out.println(session.getAttribute("access-token"));
			
			String referer = request.getHeader("referer");
			System.out.println(referer);
			return new ResponseEntity<UserLoginResponse>(
					new UserLoginResponse(user.getEmail(),
							user.getName(),
							user.getPassword(),
							user.getUserKind(),
							"success", accessToken)
					, HttpStatus.OK);
			//return "redirect:../index";
		} else {	//login fail
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인해주세요!");
			return new ResponseEntity<UserLoginResponse>(
					new UserLoginResponse("",
							"",
							"",
							0,
							"fail", "")
					, HttpStatus.OK);
			//return "user/login";
		}		
	}
	
	@PostMapping("/logout")
	private ResponseEntity<?> logout(HttpServletRequest request, @RequestBody UserLogoutRequest dto) throws SQLException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {

		String accessToken = dto.getAccessToken();
        System.out.println("logout 요청..");
        System.out.println(accessToken);
        
     // 2. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        
        
        String email = dto.getEmail();
        if (redisTemplate.opsForValue().get("RT:" + email)
        		!= null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + email);
            System.out.println("refresh token 삭제...");
        }
        
        System.out.println("더이상 유효하지 않게 된 accesstoken을 blacklist 추가..");
		// accessToken을 key로 가지며 해당 토큰의 잔여 유효시간 만큼을 
		// 유효시간으로 가지는 blacklist를 추가합니다.
        System.out.println("jwt 만료된 시간?");
        try {
        	redisTemplate.opsForValue()
            .set(accessToken, "logout", jwtService.getExpiration(accessToken), TimeUnit.MILLISECONDS);
        	logger.info("accessToken을 blacklist에 추가");
        } catch (ExpiredJwtException e) {
        	logger.info("accessToken이 이미 만료되었음.");
        }
		
//		session.invalidate();
		//return "redirect:../";
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
	
	@GetMapping("/emailcheck")
	@ResponseBody
	private int emailcheck(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String email = request.getParameter("email");
		System.out.println("email........." + email);
		try {
			int count = userService.emailCheck(email);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 500;
	}
	
//	@GetMapping("/register")
//	private String registerForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//		System.out.println(123123);
//		return "/user/register";
//	}
//	

	
	@PostMapping("/register")
	private ResponseEntity<String> register(@RequestBody User user) throws SQLException {
		System.out.println("regist....");
		
		System.out.println("join: " + user);
		userService.join(user);
		//return "redirect:../";
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

}

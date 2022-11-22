package com.ssafy.Whereismyhouse.user.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;

import com.ssafy.Whereismyhouse.house.model.dto.House;
import com.ssafy.Whereismyhouse.housedealonsale.controller.HouseDealOnSaleController;
import com.ssafy.Whereismyhouse.user.model.dto.User;
import com.ssafy.Whereismyhouse.user.model.dto.UserLogin;
import com.ssafy.Whereismyhouse.user.model.service.UserService;
import com.ssafy.Whereismyhouse.util.JwtServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

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

	@GetMapping("delete")
	private ResponseEntity<?> delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		String email = user.getEmail();
		String pwd = user.getPassword();
		System.out.println("delete..." + email + ", " + pwd);
		int res = userService.delete(email, pwd);
		System.out.println(res);
		
		return new ResponseEntity<List<House>>(HttpStatus.OK);
		
		//return "redirect:../";
	}


	private String update(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String email = ((User) session.getAttribute("userInfo")).getEmail();
		String pwd = request.getParameter("pwd");

		User user = new User(name, pwd, email);

		session.setAttribute("userInfo", user);
		String referer = request.getHeader("referer");
		System.out.println(referer);

		userService.update(user);
		
		return "redirect:user/profile";
	}

	
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
	private ResponseEntity<?> modifyProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, MalformedJwtException, SignatureException, UnsupportedEncodingException {
	    System.out.println("프로필 수정...");
		
		
		HttpSession session = request.getSession();
	    
	    
	    String name = request.getParameter("name");
	    String email = ((User) session.getAttribute("userInfo")).getEmail();
	    String pwd = request.getParameter("pwd");
	    
	  /* 
	    // jwt access 토큰이 유효한지 아닌지 검사합니다.
	    // 유효하다면 변경 작업을 그대로 수행하고,
	    // 유효하지 않다면 해당 이메일로 redis의 리프레시 토큰이 있는지 검사,
	    		// 리프레시 토큰이 유효한 경우 ->  액세스 토큰을 재발급
	    		// 리프레시 토큰이 유효하지 않으면 액세스 토큰과 refresh 토큰을 재발급
	    
	  */  
	    User user = new User(email, name, pwd);

	    
	    
	    String accessToken = (String) session.getAttribute("access-token");
		// 1. Access Token 검증
        if (!jwtService.validateToken(accessToken)) {
        	System.out.println();
            // 유효하지 않은 access token인 경우 액세스 토큰과 refresh 토큰을 재발급
        	System.out.println("유효하지 않은 access token인 경우 액세스 토큰과 refresh 토큰을 재발급");
			accessToken = jwtService.createAccessToken("userid", email);// key, data
			String refreshToken = jwtService.createRefreshToken("userid", email);// key, data
			
			session = request.getSession();
			session.setAttribute("userInfo", user);
			session.setAttribute("access-token", accessToken);
			redisTemplate.opsForValue()
            .set("RT:" + email, refreshToken, REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
			
        }
	    
	    
	    
	    

	    session.setAttribute("userInfo", user);
	    String referer = request.getHeader("referer");
	    System.out.println(referer);

	    userService.update(user);
	    System.out.println("modifyProfile....");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(pwd);
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
	   //return "redirect:/user/profile";

	}

	@PostMapping("/login")
	private  ResponseEntity<String> login(HttpServletRequest request, @RequestBody UserLogin dto) throws SQLException {
		logger.info(dto.toString());
		User user = userService.login(dto.getEmail(), dto.getPassword());
		System.out.println(dto.getEmail() +" " + dto.getPassword() + " " + user);

		if (user != null) {		//login success
			String accessToken = jwtService.createAccessToken("userid", user.getEmail());// key, data
			String refreshToken = jwtService.createRefreshToken("userid", user.getEmail());// key, data
			
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			session.setAttribute("access-token", accessToken);

			redisTemplate.opsForValue()
            .set("RT:" + dto.getEmail(), refreshToken, REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
			
			System.out.println("time...:" + REFRESH_TOKEN_EXPIRE_TIME );
			//session.setAttribute("refresh-token", refreshToken);
			
			System.out.println("login 성공... access token : " + accessToken);
			System.out.println(session.getAttribute("access-token"));
			
			String referer = request.getHeader("referer");
			System.out.println(referer);
			return new ResponseEntity<String>("success", HttpStatus.OK);
			//return "redirect:../index";
		} else {	//login fail
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인해주세요!");
			return new ResponseEntity<String>("fail", HttpStatus.OK);
			//return "user/login";
		}		
	}
	
	@GetMapping("/logout")
	private ResponseEntity<?> logout(HttpServletRequest request, Model model) throws SQLException, ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("access-token");
        System.out.println("logout 요청..");

        
     // 2. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        User user = (User) session.getAttribute("userInfo");
        String email = user.getEmail();
        if (redisTemplate.opsForValue().get("RT:" + email)
        		!= null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + email);
            System.out.println("refresh token 삭제...");
        }
        
        System.out.println("더이상 유효하지 않게 된 accesstoken을 blacklist 추가..");
		// accessToken을 key로 가지며 해당 토큰의 잔여 유효시간 만큼을 
		// 유효시간으로 가지는 blacklist를 추가합니다.
		redisTemplate.opsForValue()
        .set(accessToken, "logout", jwtService.getExpiration(accessToken), TimeUnit.MILLISECONDS);
		session.invalidate();
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

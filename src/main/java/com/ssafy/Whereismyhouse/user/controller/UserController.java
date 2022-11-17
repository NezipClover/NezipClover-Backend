package com.ssafy.Whereismyhouse.user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.Whereismyhouse.user.model.dto.User;
import com.ssafy.Whereismyhouse.user.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
	private String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		String email = user.getEmail();
		String pwd = user.getPassword();
		System.out.println("delete..." + email + ", " + pwd);
		int res = userService.delete(email, pwd);
		System.out.println(res);
		return "redirect:../";
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
	private String modifyProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	    HttpSession session = request.getSession();
	    
	    String name = request.getParameter("name");
	    String email = ((User) session.getAttribute("userInfo")).getEmail();
	    String pwd = request.getParameter("pwd");
	    
	    User user = new User(email, name, pwd);

	    session.setAttribute("userInfo", user);
	    String referer = request.getHeader("referer");
	    System.out.println(referer);

	    userService.update(user);
	    System.out.println("modifyProfile....");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(pwd);
	    
	    return "redirect:/user/profile";

	}

	@PostMapping("/login")
	private String login(HttpServletRequest request, Model model) throws SQLException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.login(email, password);
		System.out.println(email +" " + password + " " + user);
		if (user != null) {		//login success
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			String referer = request.getHeader("referer");
			System.out.println(referer);
			
			return "redirect:../index";
		} else {	//login fail
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인해주세요!");
			return "user/login";
		}		
	}
	
	@GetMapping("/logout")
	private String logout(HttpServletRequest request, Model model) throws SQLException {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:../";
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
	
	@GetMapping("/register")
	private String registerForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println(123123);
		return "/user/register";
	}
	

	
	@PostMapping("/register")
	private String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("regist....");
		User user = new User(
				request.getParameter("email"),
				request.getParameter("name"),
				request.getParameter("password")		
				);
		System.out.println("join: " + user);
		userService.join(user);
		return "redirect:../";
	}

}

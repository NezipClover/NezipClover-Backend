package com.ssafy.Whereismyhouse.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.Whereismyhouse.user.model.dto.Bookmark;
import com.ssafy.Whereismyhouse.user.model.dto.User;
import com.ssafy.Whereismyhouse.user.model.service.BookmarkService;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private BookmarkService bookmarkService;
	


//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//		String action = request.getServletPath();
//		System.out.println("action..." + action);
//		String path = "index.jsp";
//		
//		try {
//			switch (action) {
//			case "/searchAll.bookmark":
//				path = searchAll(request, response);
//				break;
//			case "/insert.bookmark":
//				path = insert(request, response);
//				break;
//			case "/delete.bookmark":
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

	@PostMapping("insert")
	private String insert(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		String id = ((User) session.getAttribute("userInfo")).getEmail();
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		String dong = request.getParameter("dong");
//		String code = request.getParameter("dongCode");
		bookmarkService.insert(id, sido, gugun, dong);
		return "redirect:searchAll";
	}
	
	@GetMapping("delete")
	private String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		String id = ((User) session.getAttribute("userInfo")).getEmail();
		String code = request.getParameter("dongCode");
		bookmarkService.delete(id, code);
		return "redirect:searchAll";
	}

	@GetMapping("searchAll")
	private String searchAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = ((User) request.getSession().getAttribute("userInfo")).getEmail();
		List<Bookmark> bookmarks = bookmarkService.searchAll(id);		
		System.out.println(bookmarks);
		request.setAttribute("bookmarks", bookmarks);
		return "lookup";
	}

}

package com.ssafy.Whereismyhouse.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.Whereismyhouse.user.model.dto.User;

@Component
public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");

		if (user != null) {
			System.out.println("if");
			return true;
		} else {
			System.out.println("else");
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인해주세요!");
			
			return false;
		}
	}
}
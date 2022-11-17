package com.ssafy.Whereismyhouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, Model model) {
		logger.error("Exception 발생 : {}" , ex.getMessage());
		model.addAttribute("msg", "처리 중 에러 발생!!!");
		return "error/error";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleException(RuntimeException ex, Model model) {
		logger.error("Exception 발생 : {}" , ex.getMessage());
		model.addAttribute("msg", ex.getMessage());
		return "error/error";
	}
}

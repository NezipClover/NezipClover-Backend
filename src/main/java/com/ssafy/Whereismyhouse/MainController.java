package com.ssafy.Whereismyhouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping({"/"})
	public String login() {
		return "user/login";
	}

	
	@GetMapping({"/sitemap"})
	public String sitemap() {
		return "site_map";
	}
	
	@GetMapping({"/info"})
	public String info() {
		return "info";
	}
	
	
	@GetMapping({"/index"})
	public String index() {
		return "index";
	}
	
}

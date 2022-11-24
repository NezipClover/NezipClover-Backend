package com.ssafy.Whereismyhouse.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.Whereismyhouse.interceptor.UserInterceptor;

//@Configuration
//@EnableAspectJAutoProxy
//@MapperScan(basePackages = { "com.ssafy.Whereismyhouse.interceptor" })
@Configuration
@ComponentScan(basePackages="com.ssafy.Whereismyhouse.interceptor.**")
public class WebMvcConfiguration implements WebMvcConfigurer {

	
	private final List<String> excludePatterns = Arrays.asList("/", "user/login", "user/register");
	private final List<String> includePatterns = Arrays.asList("/", "user/login", "user/register", "question/list/**");
 
	@Autowired
	private UserInterceptor userInterceptor;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//	        System.out.println("CORS Setting");
//	        default 설정.
//	        Allow all origins.
//	        Allow "simple" methods GET, HEAD and POST.
//	        Allow all headers.
//	        Set max age to 1800 seconds (30 minutes).
	        registry.addMapping("/*").allowedOrigins("")
//	        .allowedOrigins("http://localhost:8080", "http://localhost:8081")
	            .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
	                    HttpMethod.DELETE.name(), HttpMethod.HEAD.name(), HttpMethod.OPTIONS.name(),
	                    HttpMethod.PATCH.name())
//	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD")
	            .maxAge(1800);
	    }

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor).excludePathPatterns(excludePatterns).addPathPatterns(includePatterns);
	}

	

}

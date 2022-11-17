package com.ssafy.Whereismyhouse.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
	private final List<String> includePatterns = Arrays.asList("/", "user/login", "user/register");
 
	@Autowired
	private UserInterceptor userInterceptor;



	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor).excludePathPatterns(excludePatterns).addPathPatterns(includePatterns);
	}

	

}

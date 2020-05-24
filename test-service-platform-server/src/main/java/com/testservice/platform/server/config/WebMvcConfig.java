package com.testservice.platform.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.testservice.platform.server.filters.SelfCorsFilter;

/**
 * Spring Security配置
 * 
 * @author administrator
 * @date Jan 14, 2019
 */
@SpringBootConfiguration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private SelfCorsFilter selfCorsFilter;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(selfCorsFilter).addPathPatterns("/**");
	}
}
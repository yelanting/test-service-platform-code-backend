package com.testservice.platform.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import com.testservice.platform.server.security.JwtAuthenticationFilter;
import com.testservice.platform.server.security.JwtAuthenticationProvider;

/**
 * Spring Security配置
 * 
 * @author administrator
 * @date Jan 14, 2019
 */
@Configuration
@EnableWebSecurity // 开启Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启权限注解，如：@PreAuthorize注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
		auth.authenticationProvider(
		        new JwtAuthenticationProvider(userDetailsService));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
		http.cors().and().csrf().disable();
		http.headers().frameOptions().disable();

		http.authorizeRequests()
		        // 跨域预检请求
		        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		        // web jars
		        .antMatchers("/webjars/**").permitAll()
		        // 查看SQL监控（druid）
		        .antMatchers("/druid/**").permitAll()
		        // actuator监控和熔断部分
		        .antMatchers("/actuator", "/actuator/**", "/hystrix/**",
		                "/proxy.stream")
		        .permitAll()
		        // 禅道相关api
		        .antMatchers("/zentao/**", "/zenTaoConfig/**").permitAll()
		        // 首页和登录页面
		        .antMatchers("/").permitAll()
		        .antMatchers("/error/**", "/404", "/403", "/500", "/error")
		        .permitAll()
		        .antMatchers("/login", "/loginWithoutCaptcha", "/error")

		        .permitAll()
		        // 注册开放
		        .antMatchers("/register/**", "/test*/**").permitAll()
		        .antMatchers("/mobile/**").permitAll()
		        // 开发获取角色接口，方便注册
		        .antMatchers("/role/findAll").permitAll()
		        // swagger
		        .antMatchers("/swagger-ui.html").permitAll()
		        .antMatchers("/swagger-resources/**").permitAll()
		        .antMatchers("/v2/api-docs").permitAll()
		        .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
		        // 验证码
		        .antMatchers("/captcha.jpg**").permitAll()
		        // 服务监控
		        .antMatchers("/actuator/**").permitAll()
		        // 其他所有请求需要身份认证
		        .anyRequest().authenticated();
		// 退出登录处理器
		http.logout().logoutSuccessHandler(
		        new HttpStatusReturningLogoutSuccessHandler());
		// token验证过滤器
		http.addFilterBefore(
		        new JwtAuthenticationFilter(authenticationManager()),
		        UsernamePasswordAuthenticationFilter.class);

		// http.addFilterAfter(new AccessControlAllowedOriginFilter(),
		// UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
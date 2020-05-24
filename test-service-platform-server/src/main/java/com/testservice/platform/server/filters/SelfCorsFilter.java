/***
 * @author:孙留平
 * @since:2020 年3月17日 上午10:50:52
 * @see:
 */
package com.testservice.platform.server.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

/***
 * 
 * @author :Administrator
 * @since :2020 年3月17日 上午10:50:52
 * @see :
 */

@Configuration
public class SelfCorsFilter implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest arg0,
	        HttpServletResponse arg1, Object arg2, Exception arg3)
	        throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
	        Object arg2) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object arg2) throws Exception {

		response.setHeader("Access-Control-Allow-Origin",
		        request.getHeader("Origin"));// 支持跨域请求
		response.setHeader("Access-Control-Allow-Methods", "*");
		// 是否支持cookie跨域
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("X-Frame-Options", request.getHeader("Origin"));
		// Origin,
		// X-Requested-With,
		// Content-Type,
		// Accept,Access-Token
		response.setHeader("Access-Control-Allow-Headers",
		        "Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");
		return true;
	}
}

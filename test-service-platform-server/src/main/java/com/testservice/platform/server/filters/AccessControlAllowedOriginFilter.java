/***
 * @author:孙留平
 * @since:2020 年3月17日 上午10:50:52
 * @see:
 */
package com.testservice.platform.server.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 
 * @author :Administrator*
 * @since :2020 年3月17日 上午10:50:52
 * @see : 跨域访问过滤器
 */
// @Component
// @Order(Ordered.LOWEST_PRECEDENCE)
public class AccessControlAllowedOriginFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(AccessControlAllowedOriginFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String remoteAccess = "";
		String schema = request.getScheme();
		String domain = request.getRemoteHost();
		remoteAccess = schema + "://" + domain;
		LOGGER.debug("远程访问地址:{}", remoteAccess);
		LOGGER.debug("远程访问地址Ip:{}", request.getRemoteAddr());

		httpResponse.setHeader("Access-Control-Allow-Origin", remoteAccess);
		// httpResponse.setHeader("Access-Control-Allow-Methods",
		// "PUT,POST, GET, OPTIONS, DELETE");
		httpResponse.setHeader("Access-Control-Allow-Methods", "*");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) {
		LOGGER.debug("过滤器初始化了");
	}

	public void destroy() {
		LOGGER.debug("过滤器销毁了");
	}
}

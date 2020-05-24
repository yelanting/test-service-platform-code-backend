/**
 * @author : 孙留平
 * @since : 2020年2月26日 上午9:49:27
 * @see:
 */
package com.testservice.platform.server.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * @author : Administrator
 * @since : 2020年2月26日 上午9:49:27
 * @see :
 */

// @Configuration
// @Component("selfErrorPageRegistrar")
public class SelfErrorPageRegistrar implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage notFoundErrorPage = new ErrorPage(HttpStatus.NOT_FOUND,
		        "/404");
		ErrorPage serverExceptionErrorPage = new ErrorPage(
		        HttpStatus.INTERNAL_SERVER_ERROR, "/500");
		ErrorPage forbiddenExceptionErrorPage = new ErrorPage(
		        HttpStatus.FORBIDDEN, "/403");
		ErrorPage unAuthExceptionErrorPage = new ErrorPage(
		        HttpStatus.UNAUTHORIZED, "/401");
		registry.addErrorPages(notFoundErrorPage, serverExceptionErrorPage,
		        forbiddenExceptionErrorPage, unAuthExceptionErrorPage);
	}

}

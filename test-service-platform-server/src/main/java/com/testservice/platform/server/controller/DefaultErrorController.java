/**
 * @author : 孙留平
 * @since : 2020年2月26日 上午9:31:39
 * @see:
 */
package com.testservice.platform.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年2月26日 上午9:31:39
 * @see :
 */

@RestController
public class DefaultErrorController implements ErrorController {

	private static final Logger LOGGER = LoggerFactory
	        .getLogger(DefaultErrorController.class);

	@Autowired
	private ErrorAttributes errorAttributes;
	/**
	 * 默认错误
	 */
	private static final String path_default = "/error";

	@GetMapping("/404")
	public ResponseData pageNotFound() {
		return ResponseData.getErrorResult(404, "页面未找到");

	}

	@GetMapping("/500")
	public ResponseData serverException() {
		return ResponseData.getErrorResult(500, "服务器内部异常");

	}

	@GetMapping("/403")
	public ResponseData authException() {
		return ResponseData.getErrorResult(403, "权限异常");

	}

	@GetMapping({ path_default, "/error/" })
	public ResponseData errorException(HttpServletRequest request) {
		LOGGER.error("访问出错:{}", request);
		Integer statusCode = (Integer) request
		        .getAttribute("javax.servlet.error.status_code");

		LOGGER.error("访问出错,错误码:{}", statusCode);
		switch (statusCode) {
			case HttpStatus.SC_NOT_FOUND:
				LOGGER.error("页面未找到");
				return pageNotFound();
			case HttpStatus.SC_INTERNAL_SERVER_ERROR:
				LOGGER.error("服务器内部异常");
				return serverException();
			case HttpStatus.SC_FORBIDDEN:
				LOGGER.error("权限出错");
				return authException();
			default:
				return ResponseData.getErrorResult(500, "服务器内部未知异常了,请联系管理员");
		}

	}

	@GetMapping({ "/" })
	public ResponseData indexPage() {
		return ResponseData.getSuccessResult("访问异常，请去前端访问");

	}

	@Override
	public String getErrorPath() {
		return path_default;
	}
}

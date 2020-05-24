package com.testservice.platform.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.testservice.platform.util.vo.ResponseData;

/**
 * @see 全局异常处理
 * @author Administrator
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseData defaultErrorHandler(Exception exception) {
		exception.printStackTrace();
		LOGGER.error("访问出错了，异常信息:{}", exception.getMessage());
		final ResponseData responseData = new ResponseData();

		responseData.setMsg(exception.getMessage());
		if (exception instanceof NoHandlerFoundException) {
			responseData.setCode(404);
		} else if (exception instanceof ServerErrorException) {
			responseData.setCode(500);
		} else {
			responseData.setData(null);
			responseData.setSuccess(false);
		}

		return responseData;
	}

	/**
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = AccessDeniedException.class)
	@ResponseBody
	public ResponseData accessDeniedExceptionHandler(
	        AccessDeniedException exception) throws Exception {
		LOGGER.info("权限异常了:{}", exception.getMessage());
		ResponseData resultData = new ResponseData();
		resultData.setCode(403);
		resultData.setData(null);
		resultData.setMsg("权限不足");
		resultData.setSuccess(false);
		return resultData;
	}

	/**
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = NoHandlerFoundException.class)
	@ResponseBody
	public ResponseData notFoundExceptionHandler(
	        NoHandlerFoundException exception) throws Exception {
		LOGGER.info("页面访问异常了:{}", exception.getMessage());
		ResponseData resultData = new ResponseData();
		resultData.setCode(404);
		resultData.setData(null);
		resultData.setMsg("页面找不到");
		resultData.setSuccess(false);
		return resultData;
	}

	/**
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = ServerErrorException.class)
	@ResponseBody
	public ResponseData serverExceptionHandler(ServerErrorException exception)
	        throws Exception {
		LOGGER.info("访问异常:{}", exception.getMessage());
		ResponseData resultData = new ResponseData();
		resultData.setCode(500);
		resultData.setData(null);
		resultData.setMsg("服务器内部异常");
		resultData.setSuccess(false);
		return resultData;
	}
}

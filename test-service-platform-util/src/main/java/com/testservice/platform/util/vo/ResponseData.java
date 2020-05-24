package com.testservice.platform.util.vo;

import java.util.List;

import org.apache.http.HttpStatus;

import com.testservice.platform.util.constant.SysConstantDefine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @see 响应实体
 * @author Administrator
 * @since 2018年8月8日 12:53:36
 */
@ApiModel("返回响应数据")
public class ResponseData {
	/**
	 * 操作结果
	 */
	@ApiModelProperty(value = "操作成功与否")
	protected Boolean success = SysConstantDefine.DEFAULT_RESPONSE_STATUS;

	/**
	 * 响应状态码
	 */
	@ApiModelProperty(value = "响应状态码，200表示成功")
	protected int code = SysConstantDefine.DEFAULT_RESPONSE_CODE;

	/**
	 * 响应错误信息
	 */
	@ApiModelProperty(value = "返回响应消息内容")
	protected String msg = SysConstantDefine.DEFAULT_NO_ERROR_MSG;

	/**
	 * 响应数据
	 */
	@ApiModelProperty(value = "返回的响应数据")
	protected Object data;

	/**
	 * 如果是列表的话，结果的数量
	 */
	@ApiModelProperty(value = "返回的数据数量")
	protected int rows = 0;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResponseData() {
		this(Boolean.TRUE, SysConstantDefine.DEFAULT_RESPONSE_CODE,
		        SysConstantDefine.DEFAULT_NO_ERROR_MSG, null);
	}

	/**
	 * 全字段
	 * 
	 * @see :
	 * @param success
	 * @param code
	 * @param msg
	 * @param data
	 * @param rows
	 */
	protected ResponseData(Boolean success, int code, String msg, Object data,
	        int rows) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.rows = rows;
	}

	/**
	 * 少数量，返回值非数组
	 * 
	 * @see :
	 * @param success
	 * @param code
	 * @param msg
	 * @param data
	 */
	protected ResponseData(Boolean success, int code, String msg, Object data) {
		this(data);
		this.success = success;
		this.code = code;
		this.msg = msg;
		// this.data = data;
		// this.rows = 0;
	}

	/**
	 * 只有数据体
	 * 
	 * @see :
	 * @param data
	 */
	protected ResponseData(Object data) {
		this.data = data;

		/**
		 * 如果是数组
		 */
		if (null == data) {
			this.rows = 0;
		} else if (data instanceof List) {
			List dataList = (List) (data);
			this.rows = dataList.size();
		} else if (data.getClass().isArray()) {
			Object[] objectArray = (Object[]) (data);
			this.rows = objectArray.length;
		} else {
			this.rows = 0;
		}
	}

	/**
	 * 只有数据体
	 * 
	 * @see :
	 * @param data
	 */
	protected ResponseData(Object data, int size) {
		this.data = data;
		this.rows = size;
	}

	protected ResponseData(String msg, Object data) {
		this(data);

		if (msg.isEmpty()) {
			this.success = Boolean.TRUE;
			this.msg = null;
		} else {
			this.msg = msg;
			this.success = Boolean.FALSE;
		}

		// this.data = data;
		// this.rows = 0;
	}

	protected ResponseData(int code, String msg) {
		if (msg.isEmpty()) {
			this.success = Boolean.TRUE;
			this.msg = null;
		} else {
			this.msg = msg;
			this.success = Boolean.FALSE;
			this.code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
		}

		// this.data = data;
		// this.rows = 0;
	}

	public static ResponseData getSuccessResult() {
		// return new ResponseData(Boolean.TRUE, 0, "", null, 0);
		return new ResponseData();
	}

	public static ResponseData getSuccessResult(Object data) {
		// return new ResponseData(Boolean.TRUE, 0, "", data, 0);
		return new ResponseData(data);
	}

	public static ResponseData getSuccessResult(Object data, String message) {
		return new ResponseData(message, data);
	}

	public static ResponseData getSuccessResult(String message) {
		return new ResponseData(message, null);
	}

	public static ResponseData getSuccessResult(Object data, int size) {
		return new ResponseData(data, size);
	}

	public static ResponseData getErrorResult(int code, String errorMsg) {
		return new ResponseData(code, errorMsg);
	}

	public static ResponseData getErrorResult() {
		return getErrorResult(HttpStatus.SC_INTERNAL_SERVER_ERROR,
		        "未知异常，请联系管理员");
	}

	public static ResponseData getErrorResult(String msg) {
		return getErrorResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
}

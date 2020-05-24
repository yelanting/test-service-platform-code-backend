package com.testservice.platform.util.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @see 响应实体
 * @author Administrator
 * @since 2018年8月8日 12:53:36
 */
@ApiModel("返回响应数据")
public class YunXiaoResponseData extends ResponseData {
	@ApiModelProperty(value = "返回的数据，云效用")
	protected Object result;

	@ApiModelProperty(value = "返回的错误信息，云效用")
	protected String errorMsg;

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

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg
	 *            the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public YunXiaoResponseData() {

	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseData [success=" + success + ", code=" + code + ", msg="
		        + msg + ", data=" + data + ", rows=" + rows + ", result="
		        + result + ", errorMsg=" + errorMsg + "]";
	}

	protected YunXiaoResponseData(Boolean success, int code, String msg,
	        Object data, int rows) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.rows = rows;
		this.result = data;
		this.errorMsg = msg;
	}

	protected YunXiaoResponseData(Boolean success, int code, String msg,
	        Object data) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.rows = 0;
		this.result = data;
		this.errorMsg = msg;
	}

	public static YunXiaoResponseData getSuccessResult() {
		return new YunXiaoResponseData(Boolean.TRUE, 0, "", null, 0);
	}

	public static YunXiaoResponseData getSuccessResult(Object data) {
		return new YunXiaoResponseData(Boolean.TRUE, 0, "", data, 0);
	}

	public static YunXiaoResponseData getSuccessResult(Object data,
	        String message) {
		return new YunXiaoResponseData(Boolean.TRUE, 0, message, data, 0);
	}

	public static YunXiaoResponseData getSuccessResult(String message) {
		return new YunXiaoResponseData(Boolean.TRUE, 0, message, null, 0);
	}

	public static YunXiaoResponseData getSuccessResult(Object data, int size) {
		return new YunXiaoResponseData(Boolean.TRUE, 0, "", data, size);
	}

	public static YunXiaoResponseData getErrorResult(int code,
	        String errorMsg) {
		return new YunXiaoResponseData(Boolean.FALSE, code, null, errorMsg);
	}
}

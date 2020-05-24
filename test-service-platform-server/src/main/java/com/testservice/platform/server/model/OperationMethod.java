/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午12:51:48
 * @see:
 */
package com.testservice.platform.server.model;

import com.testservice.platform.server.enums.PerformActionEnum;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午12:51:48
 * @see :
 */
public class OperationMethod {
	private PerformActionEnum actionEnum;
	private boolean encrypt;
	private OperationParam operationParam;

	public PerformActionEnum getActionEnum() {
		return actionEnum;
	}

	public void setActionEnum(PerformActionEnum actionEnum) {
		this.actionEnum = actionEnum;
	}

	public boolean isEncrypt() {
		return encrypt;
	}

	public void setEncrypt(boolean encrypt) {
		this.encrypt = encrypt;
	}

	public OperationParam getOperationParam() {
		return operationParam;
	}

	public void setOperationParam(OperationParam operationParam) {
		this.operationParam = operationParam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((actionEnum == null) ? 0 : actionEnum.hashCode());
		result = prime * result + (encrypt ? 1231 : 1237);
		result = prime * result
		        + ((operationParam == null) ? 0 : operationParam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OperationMethod other = (OperationMethod) obj;
		if (actionEnum != other.actionEnum) {
			return false;
		}
		if (encrypt != other.encrypt) {
			return false;
		}
		if (operationParam == null) {
			if (other.operationParam != null) {
				return false;
			}
		} else if (!operationParam.equals(other.operationParam)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "OperationMethod [actionEnum=" + actionEnum + ", encrypt="
		        + encrypt + ", operationParam=" + operationParam + "]";
	}

}

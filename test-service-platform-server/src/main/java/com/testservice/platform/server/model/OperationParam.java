/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午1:24:48
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午1:24:48
 * @see :
 */
public class OperationParam {
	private String localClickPos;

	public String getLocalClickPos() {
		return localClickPos;
	}

	public void setLocalClickPos(String localClickPos) {
		this.localClickPos = localClickPos;
	}

	@Override
	public String toString() {
		return "OperationParam [localClickPos=" + localClickPos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((localClickPos == null) ? 0 : localClickPos.hashCode());
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
		OperationParam other = (OperationParam) obj;
		if (localClickPos == null) {
			if (other.localClickPos != null) {
				return false;
			}
		} else if (!localClickPos.equals(other.localClickPos)) {
			return false;
		}
		return true;
	}

}

/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午1:44:55
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午1:44:55
 * @see :
 */
public class Extra {
	private String screenSize;

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((screenSize == null) ? 0 : screenSize.hashCode());
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
		Extra other = (Extra) obj;
		if (screenSize == null) {
			if (other.screenSize != null) {
				return false;
			}
		} else if (!screenSize.equals(other.screenSize)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Extra [screenSize=" + screenSize + "]";
	}

}

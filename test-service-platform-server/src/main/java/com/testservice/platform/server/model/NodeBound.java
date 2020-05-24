/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午1:33:51
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午1:33:51
 * @see :
 */
public class NodeBound {
	private int bottom;
	private boolean empty;
	private int left;
	private int right;
	private int top;

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	@Override
	public String toString() {
		return "NodeBound [bottom=" + bottom + ", empty=" + empty + ", left="
		        + left + ", right=" + right + ", top=" + top + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottom;
		result = prime * result + (empty ? 1231 : 1237);
		result = prime * result + left;
		result = prime * result + right;
		result = prime * result + top;
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
		NodeBound other = (NodeBound) obj;
		if (bottom != other.bottom) {
			return false;
		}
		if (empty != other.empty) {
			return false;
		}
		if (left != other.left) {
			return false;
		}
		if (right != other.right) {
			return false;
		}
		if (top != other.top) {
			return false;
		}
		return true;
	}

}

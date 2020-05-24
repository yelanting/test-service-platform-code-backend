/**
 * @author : 孙留平
 * @since : 2020年2月29日 下午5:32:03
 * @see:
 */
package com.testservice.platform.server.model;

/**
 * @author : Administrator
 * @since : 2020年2月29日 下午5:32:03
 * @see :
 */
public class StepAction extends BaseModel {
	/**
	 * 脚本id
	 */
	private Long scriptId;
	/**
	 * 操作id
	 */
	private String operationId;

	/**
	 * 操作索引
	 */
	private int operationIndex;

	/**
	 * 操作方法
	 */
	private OperationMethod operationMethod;

	/**
	 * 操作节点
	 */
	private OperationNode operationNode;

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public int getOperationIndex() {
		return operationIndex;
	}

	public void setOperationIndex(int operationIndex) {
		this.operationIndex = operationIndex;
	}

	public OperationMethod getOperationMethod() {
		return operationMethod;
	}

	public void setOperationMethod(OperationMethod operationMethod) {
		this.operationMethod = operationMethod;
	}

	public OperationNode getOperationNode() {
		return operationNode;
	}

	public void setOperationNode(OperationNode operationNode) {
		this.operationNode = operationNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((operationId == null) ? 0 : operationId.hashCode());
		result = prime * result + operationIndex;
		result = prime * result
		        + ((operationMethod == null) ? 0 : operationMethod.hashCode());
		result = prime * result
		        + ((operationNode == null) ? 0 : operationNode.hashCode());
		result = prime * result
		        + ((scriptId == null) ? 0 : scriptId.hashCode());
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
		StepAction other = (StepAction) obj;
		if (operationId == null) {
			if (other.operationId != null) {
				return false;
			}
		} else if (!operationId.equals(other.operationId)) {
			return false;
		}
		if (operationIndex != other.operationIndex) {
			return false;
		}
		if (operationMethod == null) {
			if (other.operationMethod != null) {
				return false;
			}
		} else if (!operationMethod.equals(other.operationMethod)) {
			return false;
		}
		if (operationNode == null) {
			if (other.operationNode != null) {
				return false;
			}
		} else if (!operationNode.equals(other.operationNode)) {
			return false;
		}
		if (scriptId == null) {
			if (other.scriptId != null) {
				return false;
			}
		} else if (!scriptId.equals(other.scriptId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "StepAction [scriptId=" + scriptId + ", operationId="
		        + operationId + ", operationIndex=" + operationIndex
		        + ", operationMethod=" + operationMethod + ", operationNode="
		        + operationNode + "]";
	}

	public Long getScriptId() {
		return scriptId;
	}

	public void setScriptId(Long scriptId) {
		this.scriptId = scriptId;
	}

}

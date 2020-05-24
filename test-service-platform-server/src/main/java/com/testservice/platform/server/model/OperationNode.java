/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午12:52:31
 * @see:
 */
package com.testservice.platform.server.model;

import java.util.List;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午12:52:31
 * @see :
 */
public class OperationNode {
	private List<AssistantNode> assistantNodes;
	private String className;
	private int depth;
	private String description;
	private Extra extra;
	private String id;
	private NodeBound nodeBound;
	private String nodeType;
	private String packageName;
	private String resourceId;
	private String text;
	private String xpath;

	public List<AssistantNode> getAssistantNodes() {
		return assistantNodes;
	}

	public void setAssistantNodes(List<AssistantNode> assistantNodes) {
		this.assistantNodes = assistantNodes;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NodeBound getNodeBound() {
		return nodeBound;
	}

	public void setNodeBound(NodeBound nodeBound) {
		this.nodeBound = nodeBound;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	@Override
	public String toString() {
		return "OperationNode [assistantNodes=" + assistantNodes
		        + ", className=" + className + ", depth=" + depth
		        + ", description=" + description + ", extra=" + extra + ", id="
		        + id + ", nodeBound=" + nodeBound + ", nodeType=" + nodeType
		        + ", packageName=" + packageName + ", resourceId=" + resourceId
		        + ", text=" + text + ", xpath=" + xpath + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((assistantNodes == null) ? 0 : assistantNodes.hashCode());
		result = prime * result
		        + ((className == null) ? 0 : className.hashCode());
		result = prime * result + depth;
		result = prime * result
		        + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((extra == null) ? 0 : extra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
		        + ((nodeBound == null) ? 0 : nodeBound.hashCode());
		result = prime * result
		        + ((nodeType == null) ? 0 : nodeType.hashCode());
		result = prime * result
		        + ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result
		        + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((xpath == null) ? 0 : xpath.hashCode());
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
		OperationNode other = (OperationNode) obj;
		if (assistantNodes == null) {
			if (other.assistantNodes != null) {
				return false;
			}
		} else if (!assistantNodes.equals(other.assistantNodes)) {
			return false;
		}
		if (className == null) {
			if (other.className != null) {
				return false;
			}
		} else if (!className.equals(other.className)) {
			return false;
		}
		if (depth != other.depth) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (extra == null) {
			if (other.extra != null) {
				return false;
			}
		} else if (!extra.equals(other.extra)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nodeBound == null) {
			if (other.nodeBound != null) {
				return false;
			}
		} else if (!nodeBound.equals(other.nodeBound)) {
			return false;
		}
		if (nodeType == null) {
			if (other.nodeType != null) {
				return false;
			}
		} else if (!nodeType.equals(other.nodeType)) {
			return false;
		}
		if (packageName == null) {
			if (other.packageName != null) {
				return false;
			}
		} else if (!packageName.equals(other.packageName)) {
			return false;
		}
		if (resourceId == null) {
			if (other.resourceId != null) {
				return false;
			}
		} else if (!resourceId.equals(other.resourceId)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		if (xpath == null) {
			if (other.xpath != null) {
				return false;
			}
		} else if (!xpath.equals(other.xpath)) {
			return false;
		}
		return true;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

}

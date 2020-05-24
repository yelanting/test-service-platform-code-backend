package com.testservice.platform.server.model;

import java.util.List;

public class SysDept extends BaseModel {

	private String name;

	private Long parentId;

	private Integer orderNum;

	private Byte delFlag;
	// 非数据库字段
	private List<SysDept> children;
	// 非数据库字段
	private String parentName;
	// 非数据库字段
	private Integer level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	public List<SysDept> getChildren() {
		return children;
	}

	public void setChildren(List<SysDept> children) {
		this.children = children;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SysDept [name=" + name + ", parentId=" + parentId
		        + ", orderNum=" + orderNum + ", delFlag=" + delFlag
		        + ", children=" + children + ", parentName=" + parentName
		        + ", level=" + level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		        + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((delFlag == null) ? 0 : delFlag.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
		        + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result
		        + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result
		        + ((parentName == null) ? 0 : parentName.hashCode());
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
		SysDept other = (SysDept) obj;
		if (children == null) {
			if (other.children != null) {
				return false;
			}
		} else if (!children.equals(other.children)) {
			return false;
		}
		if (delFlag == null) {
			if (other.delFlag != null) {
				return false;
			}
		} else if (!delFlag.equals(other.delFlag)) {
			return false;
		}
		if (level == null) {
			if (other.level != null) {
				return false;
			}
		} else if (!level.equals(other.level)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (orderNum == null) {
			if (other.orderNum != null) {
				return false;
			}
		} else if (!orderNum.equals(other.orderNum)) {
			return false;
		}
		if (parentId == null) {
			if (other.parentId != null) {
				return false;
			}
		} else if (!parentId.equals(other.parentId)) {
			return false;
		}
		if (parentName == null) {
			if (other.parentName != null) {
				return false;
			}
		} else if (!parentName.equals(other.parentName)) {
			return false;
		}
		return true;
	}

}
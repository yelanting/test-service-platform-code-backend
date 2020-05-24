/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午1:30:19
 * @see:
 */
package com.testservice.platform.server.model;

import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午1:30:19
 * @see :
 */
public class AssistantNode {
	/**
	 * 子节点类名
	 */
	private String className = null;

	/**
	 * 子节点resourceId
	 */
	private String resourceId = null;

	/**
	 * 子节点text
	 */
	private String text = null;

	/**
	 * 子节点description
	 */
	private String description = null;

	/**
	 * 子节点在父节点层级
	 */
	private int parentHeight = 0;

	/**
	 * JSON用
	 */
	public AssistantNode() {
	}

	public AssistantNode(String className, String resourceId, String text,
	        String description, int parentHeight) {
		this.className = className;
		this.resourceId = resourceId;
		this.text = text;
		this.parentHeight = parentHeight;
		this.description = description;
	}

	/**
	 * 计算节点优先级
	 * 
	 * @return
	 */
	private int calculatePriority() {
		int text = StringUtil.isEmpty(getText()) ? 0 : 2;
		int resourceId = StringUtil.isEmpty(getResourceId()) ? 0 : 1;
		int description = StringUtil.isEmpty(getDescription()) ? 0 : 2;
		return text + resourceId + description;
	}

	/**
	 * Getter method for property <tt>className</tt>.
	 *
	 * @return property value of className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Setter method for property <tt>className</tt>.
	 *
	 * @param className
	 *            value to be assigned to property className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Getter method for property <tt>resourceId</tt>.
	 *
	 * @return property value of resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * Setter method for property <tt>resourceId</tt>.
	 *
	 * @param resourceId
	 *            value to be assigned to property resourceId
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * Getter method for property <tt>text</tt>.
	 *
	 * @return property value of text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setter method for property <tt>text</tt>.
	 *
	 * @param text
	 *            value to be assigned to property text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Getter method for property <tt>parentHeight</tt>.
	 *
	 * @return property value of parentHeight
	 */
	public int getParentHeight() {
		return parentHeight;
	}

	/**
	 * Setter method for property <tt>parentHeight</tt>.
	 *
	 * @param parentHeight
	 *            value to be assigned to property parentHeight
	 */
	public void setParentHeight(int parentHeight) {
		this.parentHeight = parentHeight;
	}

	/**
	 * Getter method for property <tt>description</tt>.
	 *
	 * @return property value of description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter method for property <tt>description</tt>.
	 *
	 * @param description
	 *            value to be assigned to property description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

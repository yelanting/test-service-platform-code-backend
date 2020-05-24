/**
 * @author : 孙留平
 * @since : 2020年3月21日 下午10:20:25
 * @see:
 */
package com.testservice.platform.server.model;

import com.testservice.platform.server.zentao.entity.ZenTaoTestTask;

/**
 * @author : Administrator
 * @since : 2020年3月21日 下午10:20:25
 * @see :
 */
public class ZenTaoTestTaskModel extends BaseModel {
	/**
	 */
	private static final long serialVersionUID = -5555829474863221528L;

	private Long zenTaoTestTaskId;

	private boolean delFlag;

	private ZenTaoTestTask zenTaoTestTask;

	public Long getZenTaoTestTaskId() {
		return zenTaoTestTaskId;
	}

	public void setZenTaoTestTaskId(Long zenTaoTestTaskId) {
		this.zenTaoTestTaskId = zenTaoTestTaskId;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "ZenTaoTestTaskModel [zenTaoTestTaskId=" + zenTaoTestTaskId
		        + ", delFlag=" + delFlag + ", zenTaoTestTask=" + zenTaoTestTask
		        + "]";
	}

	public ZenTaoTestTask getZenTaoTestTask() {
		return zenTaoTestTask;
	}

	public void setZenTaoTestTask(ZenTaoTestTask zenTaoTestTask) {
		this.zenTaoTestTask = zenTaoTestTask;
	}

}

/**
 * @author : 孙留平
 * @since : 2020年2月29日 上午1:47:26
 * @see:
 */
package com.testservice.platform.server.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Administrator
 * @since : 2020年2月29日 上午1:47:26
 * @see :
 */
public class Script extends BaseModel implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -7893864877897362898L;
	private String scriptName;
	private List<StepAction> steps;

	/**
	 * 所属apk的id
	 */
	private Long appId;

	/**
	 * 非数据库字段
	 */
	private Apk apk;

	private boolean delFlag;

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public List<StepAction> getSteps() {
		return steps;
	}

	public void setSteps(List<StepAction> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Script [scriptName=" + scriptName + ", steps=" + steps
		        + ", appId=" + appId + ", apk=" + apk + ", delFlag=" + delFlag
		        + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apk == null) ? 0 : apk.hashCode());
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + (delFlag ? 1231 : 1237);
		result = prime * result
		        + ((scriptName == null) ? 0 : scriptName.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
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
		Script other = (Script) obj;
		if (apk == null) {
			if (other.apk != null) {
				return false;
			}
		} else if (!apk.equals(other.apk)) {
			return false;
		}
		if (appId == null) {
			if (other.appId != null) {
				return false;
			}
		} else if (!appId.equals(other.appId)) {
			return false;
		}
		if (delFlag != other.delFlag) {
			return false;
		}
		if (scriptName == null) {
			if (other.scriptName != null) {
				return false;
			}
		} else if (!scriptName.equals(other.scriptName)) {
			return false;
		}
		if (steps == null) {
			if (other.steps != null) {
				return false;
			}
		} else if (!steps.equals(other.steps)) {
			return false;
		}
		return true;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Apk getApk() {
		return apk;
	}

	public void setApk(Apk apk) {
		this.apk = apk;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

}

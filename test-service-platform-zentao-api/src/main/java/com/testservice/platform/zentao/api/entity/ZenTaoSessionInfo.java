/**
 * @author : 孙留平
 * @since : 2020年3月18日 下午6:35:22
 * @see:
 */
package com.testservice.platform.zentao.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author : Administrator
 * @since : 2020年3月18日 下午6:35:22
 * @see :
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoSessionInfo {
	private String title;
	private String sessionName;
	private String sessionID;
	private String rand;
	private String pager;

	public ZenTaoSessionInfo() {
	}

	public ZenTaoSessionInfo(String title, String sessionName, String sessionID,
	        String rand, String pager) {
		super();
		this.title = title;
		this.sessionName = sessionName;
		this.sessionID = sessionID;
		this.rand = rand;
		this.pager = pager;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	@Override
	public String toString() {
		return "ZenTaoSessionInfo [title=" + title + ", sessionName="
		        + sessionName + ", sessionID=" + sessionID + ", rand=" + rand
		        + ", pager=" + pager + "]";
	}

}

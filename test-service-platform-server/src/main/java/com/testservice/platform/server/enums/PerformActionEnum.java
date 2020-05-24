/**
 * @author : 孙留平
 * @since : 2020年3月1日 上午12:54:38
 * @see:
 */
package com.testservice.platform.server.enums;

/**
 * @author : Administrator
 * @since : 2020年3月1日 上午12:54:38
 * @see :
 */

public enum PerformActionEnum {
	CANCEL("cancel", 0, 0),
	CLICK("click", 1, 0),
	LONG_CLICK("longClick", 1, 0),
	INPUT("input", 1, 0),
	MULTI_CLICK("multiClick", 1, 0),
	CLICK_IF_EXISTS("clickIfExists", 1, 0),
	CLICK_QUICK("clickQuick", 1, 0),
	INPUT_SEARCH("inputSearch", 1, 0),
	SCROLL_TO_BOTTOM("scrollToBottom", 1, 0),
	SCROLL_TO_TOP("scrollToTop", 1, 0),
	SCROLL_TO_RIGHT("scrollToRight", 1, 0),
	SCROLL_TO_LEFT("scrollToLeft", 1, 0),
	GESTURE("gesture", 1, 0),
	ASSERT("assert", 1, 0),
	SLEEP_UNTIL("sleepUntil", 1, 0),
	OTHER_NODE("otherNode", 1, 0),

	BACK("back", 2, 0),
	RELOAD("reload", 2, 0),
	HANDLE_ALERT("handleAlert", 2, 0),
	JUMP_TO_PAGE("jumpToPage", 2, 0),
	CHANGE_MODE("changeMode", 4, 0),

	GLOBAL_SCROLL_TO_BOTTOM("globalScrollToBottom", 2, 0),
	GLOBAL_SCROLL_TO_TOP("globalScrollToTop", 2, 0),
	GLOBAL_SCROLL_TO_RIGHT("globalScrollToRight", 2, 0),
	GLOBAL_SCROLL_TO_LEFT("globalScrollToLeft", 2, 0),
	GLOBAL_PINCH_OUT("globalPinchOut", 2, 0),
	GLOBAL_PINCH_IN("globalPinchIn", 2, 0),
	GLOBAL_GESTURE("globalGesture", 2, 0),
	GOTO_INDEX("goToIndex", 2, 0),
	CLEAR_DATA("clearData", 2, 0),

	KILL_PROCESS("killProcess", 2, 0),
	SLEEP("sleep", 2, 0),
	SCREENSHOT("screenshot", 3, 0),
	HOME("home", 3, 0),
	NOTIFICATION("notification", 3, 0),
	RECENT_TASK("recentTask", 3, 0),
	DEVICE_INFO("deviceInfo", 3, 2),
	EXECUTE_SHELL("executeShell", 2, 0),

	PAUSE("pause", 3, 2),
	OTHER_GLOBAL("otherGlobal", 3, 0),
	FINISH("finish", 4, 0),
	FOCUS("focus", 0, 0),
	/**
	 * 运行时设置变量
	 */
	LET_NODE("letNode", 1, 1),
	LET("let", 4, 1),
	LOAD_PARAM("load", 4, 1),
	CHECK_NODE("checkNode", 1, 1),
	CHECK("check", 4, 1),

    /**
     * 本地模式专用 5
     */

	/**
	 * 内部操作，不对外
	 */
	HANDLE_PERMISSION_ALERT("permissionAlert", -2, 0),
	HIDE_INPUT_METHOD("inputMethod", -2, 0),

	/**
	 * 对用例操作
	 */
	DELETE_CASE("deleteCase", -3, 0),
	EXPORT_CASE("exportCase", -3, 0),
	PLAY_MULTI_TIMES("playMultiTimes", -3, 0),
	GEN_MULTI_PARAM("genMultiParam", -3, 0),
	/**
	 * 逻辑判断部分，由StepProvider内部处理
	 */
	WHILE("while", -2, 1),
	IF("if", -2, 1),
	CONTINUE("continue", -2, 1),
	BREAK("break", -2, 1);
	/**
	 * 操作码
	 */
	private String code;

	/**
	 * 分类
	 */
	private int category;

	/**
	 * transformation 为 0， action 为 1
	 */
	private int actionType;

	PerformActionEnum(String code, int category, int actionType) {
		this.code = code;
		this.category = category;
		this.actionType = actionType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}
}

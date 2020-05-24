/**
 * @author : 孙留平
 * @since : 2020年3月17日 下午6:07:05
 * @see:
 */
package com.testservice.platform.zentao.api.action;

/**
 * @author : Administrator
 * @since : 2020年3月17日 下午6:07:05
 * @see :
 */
public class RequestAction {

	/**
	 * 登录url
	 */
	public static final String LOGIN_ACTION_URL = "";

	/**
	 * 获取测试单url
	 */
	public static final String GET_TESTTASK_CASE_ACTION_URL = "";

	/**
	 * 获取sessionIdUrl
	 */

	public static final String GET_SESSION_ID_ACTION = "/api-getsessionid.json";

	/**
	 * 带上sessionid登陆
	 */
	public static final String USER_LOGIN_WITH_SESSION_ID_ACTION = "/user-login.json?zentaosid=%s";

	/**
	 * 退出action
	 */
	public static final String USER_LOGOUT_ACTION = "/user-logout.json";

	/**
	 * 查看任务
	 */
	public static final String TASK_VIEW_ACTION = "/task-view-%s.json";

	/**
	 * 创建任务task-create-[projectID]-[storyID]-[moduleID]-[taskID]-[todoID].json
	 */
	public static final String TASK_CREATE_ACTION = "/task-create-%s-%s-%s-%s-%s.json";

	/**
	 * 创建项目
	 */
	public static final String PROJECT_CREATE_ACTION = "/project-create.json";

	/**
	 * 获取测试单概况
	 */
	public static class TestTaskAction {
		public static final String GET_TEST_TASK_DETAIL_ACTION = "testtask-view-%s.json?onlybody=yes";
	}

	/**
	 * 测试用例
	 * 
	 * @author : Administrator
	 * @since : 2020年3月20日 上午8:08:59
	 * @see :
	 */
	public static class TestCaseAction {
		public static final String GET_TESTCASK_CASES_ACTION = "testtask-cases-%s.json";
		public static final String GET_TESTCASE_DETAIL_ACTION = "testcase-view-%s.json";
	}

}

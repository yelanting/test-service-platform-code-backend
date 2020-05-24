/**
 * @author : 孙留平
 * @since : 2020年3月20日 上午11:34:17
 * @see:
 */
package com.testservice.platform.server.zentao.entity;

import java.util.Map;

/**
 * @author : Administrator
 * @since : 2020年3月20日 上午11:34:17
 * @see :
 */
public class ZenTaoResponseTestCasesUnderTask extends ZenTaoBaseDomain {
	private ZenTaoTestVersion task;
	private Map<Long, ZenTaoTestCase> runs;

	public ZenTaoTestVersion getTask() {
		return task;
	}

	public void setTask(ZenTaoTestVersion task) {
		this.task = task;
	}

	public Map<Long, ZenTaoTestCase> getRuns() {
		return runs;
	}

	public void setRuns(Map<Long, ZenTaoTestCase> runs) {
		this.runs = runs;
	}

	@Override
	public String toString() {
		return "ZenTaoTestTaskCasesResponse [task=" + task + ", runs=" + runs
		        + "]";
	}
}

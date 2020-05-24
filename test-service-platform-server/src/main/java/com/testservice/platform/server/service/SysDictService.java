package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.model.SysDict;

/**
 * 字典管理
 * @author administrator
 * @date Jan 13, 2019
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}

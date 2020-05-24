package com.testservice.platform.server.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.testservice.platform.server.model.Script;
import com.testservice.platform.server.page.PageRequest;
import com.testservice.platform.server.page.PageResult;

/**
 * 脚本
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
public interface ScriptService extends CurdService<Script> {
	/**
	 * 根据名称查询
	 * 
	 * @param scriptName
	 * @return
	 */
	Script findByScriptName(String scriptName);

	/**
	 * 根据包名称查询
	 * 
	 * @see :
	 * @param :
	 * @return : Script
	 * @param packageName
	 * @return
	 */
	List<Script> findByPackageName(String packageName);

	/**
	 * 根据应用Id分页查询
	 * 
	 * @see :
	 * @param :
	 * @return : PageResult
	 * @param pageRequest
	 * @return
	 */
	PageResult findPageByAppId(PageRequest pageRequest);

	List<Script> findByLable(@Param(value = "label") String label);

	List<Script> findAll();

	List<Script> findAllByAppId(Long appId);
}

package com.testservice.platform.server.service;

import java.util.List;

import com.testservice.platform.server.model.Platform;

/**
 * 平台
 * 
 * @author administrator
 * @date Jan 13, 2019
 */
public interface PlatformService extends CurdService<Platform> {

	/**
	 * 根据包名称查询
	 * 
	 * @see :
	 * @param :
	 * @return : Platform
	 * @param platformName
	 * @return
	 */
	Platform findByPlatformName(String platformName);

	List<Platform> findAll();
}

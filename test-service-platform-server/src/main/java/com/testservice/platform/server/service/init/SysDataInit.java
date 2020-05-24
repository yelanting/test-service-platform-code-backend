/**
 * @author : 孙留平
 * @since : 2020年2月26日 下午7:43:52
 * @see:
 */
package com.testservice.platform.server.service.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.constant.SysInitDataConstants;
import com.testservice.platform.server.model.SysDept;
import com.testservice.platform.server.service.SysDeptService;

/**
 * @author : Administrator
 * @since : 2020年2月26日 下午7:43:52
 * @see :
 */

@Service("sysDataInit")
public class SysDataInit {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(SysDataInit.class);

	@Autowired
	private SysDeptService sysDeptService;

	@PostConstruct
	public void initData() {
		LOGGER.debug("初始化一些系统数据");
		initADefaultRole();

		initADefaultDept();
		LOGGER.debug("初始化系统数据完成");

	}

	/**
	 * 初始化一个默认角色，给注册用户使用
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 */
	private void initADefaultRole() {

	}

	/**
	 * 初始化一个默认部门
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 */
	private void initADefaultDept() {
		LOGGER.debug("初始化一个默认的部门");
		SysDept sysDept = new SysDept();
		sysDept.setCreateBy(SysInitDataConstants.DEFAULT_ADMIN_USER);
		sysDept.setLastUpdateBy(SysInitDataConstants.DEFAULT_ADMIN_USER);
		sysDept.setParentId(null);
		sysDept.setOrderNum(0);
		sysDept.setName(SysInitDataConstants.DEFAULT_DEPT_NAME);

		SysDept currentDefaultDept = sysDeptService.findByNameAndParentId(
		        SysInitDataConstants.DEFAULT_DEPT_NAME, null);
		// 如果已经存在，则检查是否一样吗，不一样则修改，一样则不动
		if (null != currentDefaultDept) {
			if (sysDept.equals(currentDefaultDept)) {
				return;
			} else {
				sysDept.setId(currentDefaultDept.getId());
				sysDept.setLastUpdateTime(new Date());
				sysDeptService.save(sysDept);
			}
		}

		// 如果不存在，则新增一个
		LOGGER.debug("没有该部门，新增一个");
		sysDept.setCreateTime(new Date());
		sysDeptService.save(sysDept);

	}

}

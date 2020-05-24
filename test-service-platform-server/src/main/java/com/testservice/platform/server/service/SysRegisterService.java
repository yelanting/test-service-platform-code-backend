/**
 * @author : 孙留平
 * @since : 2020年2月26日 上午10:40:29
 * @see:
 */
package com.testservice.platform.server.service;

import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.server.vo.RegisterBean;

/**
 * @author : Administrator
 * @since : 2020年2月26日 上午10:40:29
 * @see :
 */
public interface SysRegisterService {
	SysUser register(RegisterBean registerBean);
}

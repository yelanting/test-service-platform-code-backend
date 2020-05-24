/**
 * @author : 孙留平
 * @since : 2020年2月25日 上午12:02:16
 * @see:
 */
package com.testservice.platform.server.global;

import org.springframework.security.core.Authentication;

import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年2月25日 上午12:02:16
 * @see :
 */
public class GlobalAuth {
    private GlobalAuth() {

    }

    // public static Authentication AUTHENTICATION = SecurityContextHolder
    // .getContext().getAuthentication();
    public static Authentication AUTHENTICATION = SecurityUtils
            .getAuthentication();

    public static String USERNAME = (null == AUTHENTICATION) ? "匿名用户"
            : (StringUtil.isEmpty(AUTHENTICATION.getName()) ? "匿名用户"
                    : AUTHENTICATION.getName());

    public static final String DEFUALT_OWNER = "DEFAULT";

}

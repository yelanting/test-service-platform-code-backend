/**
 * @author : 孙留平
 * @since : 2020年3月20日 上午8:34:31
 * @see:
 */
package com.testservice.platform.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.testservice.platform.server.constant.SysInitDataConstants;
import com.testservice.platform.server.global.GlobalAuth;
import com.testservice.platform.server.model.GlobalParam;
import com.testservice.platform.server.service.GlobalParamService;
import com.testservice.platform.server.util.SecurityUtils;
import com.testservice.platform.server.zentao.ZenTaoHttpHelper;
import com.testservice.platform.server.zentao.entity.ZenTaoServerInfo;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年3月20日 上午8:34:31
 * @see :
 */
@Service("zenTaoRequestBaseService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZenTaoRequestBaseService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ZenTaoRequestBaseService.class);
    @Autowired
    private GlobalParamService globalParamService;

    public ZenTaoRequestBaseService() {
        super();
    }

    /**
     * 获取自定义的或者默认的参数
     */
    private GlobalParam getUserDefinedOrDefaultParam(String paramKey) {
        String username = SecurityUtils.getUsername();
        String defaultUsername = GlobalAuth.DEFUALT_OWNER;
        GlobalParam globalParam = null;

        if (StringUtil.isEmpty(username)) {
            globalParam = globalParamService.findByParamKeyAndOwner(paramKey,
                    defaultUsername);
        } else if (null == globalParamService.findByParamKeyAndOwner(paramKey,
                username)) {
            globalParam = globalParamService.findByParamKeyAndOwner(paramKey,
                    defaultUsername);
        } else {
            globalParam = globalParamService.findByParamKeyAndOwner(paramKey,
                    username);
        }
        LOGGER.debug("查找用户专属的，或者默认的参数配置:{},当前用户:{}", paramKey, username);
        LOGGER.debug("查找到的内容为:{}", globalParam);
        return globalParam;
    }

    /**
     * 获取基础请求类
     * 
     * @return
     */
    protected ZenTaoRequestCommonService getZenTaoRequestCommonService() {
        LOGGER.debug("getZenTaoRequestCommonService:进行初始化操作");
        GlobalParam usernameGlobalParam = getUserDefinedOrDefaultParam(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_USERNAME_KEY);
        GlobalParam passwordGlobalParam = getUserDefinedOrDefaultParam(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_LOGIN_PASSWORD_KEY);
        GlobalParam zentaoServerUrlGlobalParam = getUserDefinedOrDefaultParam(
                SysInitDataConstants.GlobalParamInitConst.ZENTAO_URL_KEY);
        ZenTaoServerInfo zenTaoServerInfo = null;
        LOGGER.debug(
                "usernameGlobalParam:{},passwordGlobalParam:{},zentaoServerUrlGlobalParam:{}",
                usernameGlobalParam, passwordGlobalParam,
                zentaoServerUrlGlobalParam);
        if (null == usernameGlobalParam || null == passwordGlobalParam
                || null == zentaoServerUrlGlobalParam) {
            zenTaoServerInfo = ZenTaoServerInfo.getDefaultZenTaoServerInfo();
        } else {
            zenTaoServerInfo = new ZenTaoServerInfo.Builder()
                    .zenTaoServerUrl(zentaoServerUrlGlobalParam.getParamValue())
                    .loginUsername(usernameGlobalParam.getParamValue())
                    .loginPassword(passwordGlobalParam.getParamValue()).build();
        }
        LOGGER.debug("zenTaoServerInfo:{}", zenTaoServerInfo);
        ZenTaoRequestCommonService zenTaoRequestCommonService = new ZenTaoRequestCommonService(
                new ZenTaoHttpHelper(zenTaoServerInfo));
        return zenTaoRequestCommonService;
    }
}

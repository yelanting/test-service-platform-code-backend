/**
 * Project Name: manager-platform-server File Name: YunXiaoLoginHelper.java
 * Package Name: com.administrator.platform.helper.yunxiao Date: 2019年10月9日
 * 下午4:52:16 Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.testservice.platform.server.zentao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;

import com.testservice.platform.server.http.ParamsKeyValueUtil;
import com.testservice.platform.server.http.RestTemplateFactory;
import com.testservice.platform.server.zentao.entity.ZenTaoServerInfo;
import com.testservice.platform.server.zentao.util.ZenTaoUtil;
import com.testservice.platform.zentao.api.action.RequestAction;
import com.testservice.platform.zentao.api.define.ConstDefine;
import com.testservice.platform.zentao.api.entity.ZenTaoApiResponseObject;
import com.testservice.platform.zentao.api.entity.ZenTaoSessionInfo;
import com.testservice.platform.util.core.JsonUtil;
import com.testservice.platform.util.core.StringUtil;
import com.testservice.platform.util.exception.base.BusinessValidationException;

/**
 * @author : 孙留平
 * @since : 2019年10月9日 下午4:52:16
 * @see :
 */
public class ZenTaoLoginHelper {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ZenTaoLoginHelper.class);
    private ZenTaoServerInfo zenTaoServerInfo;
    private String zenTaoSessionId;

    public ZenTaoLoginHelper() {
        this(new ZenTaoServerInfo.Builder()
                .zenTaoServerUrl(ConstDefine.DEFAULT_ZENTAO_URL)
                .loginUsername(ConstDefine.DEFAULT_LOGIN_ROOT_USER)
                .loginPassword(ConstDefine.DEFAULT_LOGIN_ROOT_PASSWORD)
                .build());
    }

    public ZenTaoLoginHelper(ZenTaoServerInfo zenTaoServerInfo) {
        // login(zenTaoServerInfo.getZenTaoServerUrl(),
        // zenTaoServerInfo.getLoginUsername(),
        // zenTaoServerInfo.getLoginPassword());
        this.zenTaoServerInfo = zenTaoServerInfo;
        // login(zenTaoServerInfo);

    }

    /**
     * 登录操作
     */
    public void login(String zentaoServerUrl, String username,
            String password) {

        LOGGER.debug(
                "public void login(String zentaoServerUrl, String username, String password)被调用");
        Map<String, String> postMap = new HashedMap<>();
        postMap.put("account", username);
        // postMap.put("password", Md5Util.createMd5Str(password));
        postMap.put("password", password);
        postMap.put("passwordStrength", "2");
        postMap.put("keepLogin", "1");

        /**
         * 获取sessionid
         */
        ZenTaoApiResponseObject zenTaoApiResponseObject = getSessionId();

        Object object = zenTaoApiResponseObject.getData();
        // ZenTaoSessionInfo zenTaoSessionInfo = JsonUtil.jsonToObject(
        // JSON.toJSONString(object), ZenTaoSessionInfo.class);
        ZenTaoSessionInfo zenTaoSessionInfo = JsonUtil.jsonToObject(object,
                ZenTaoSessionInfo.class);

        LOGGER.debug("zenTaoSessionInfo:{}", zenTaoSessionInfo);
        String sessionId = zenTaoSessionInfo.getSessionID();

        String loginWithSessionIdUrl = String.format("%s%s",
                RequestAction.USER_LOGIN_WITH_SESSION_ID_ACTION, sessionId);
        LOGGER.debug("loginWithSessionIdUrl:{}", loginWithSessionIdUrl);
        ResponseEntity<String> loginResponseEntity = postWithOutLogin(
                loginWithSessionIdUrl, postMap);

        LOGGER.debug("LoginResponse:{}", loginResponseEntity);
        LOGGER.debug("LoginResponseText:{}", loginResponseEntity.getBody());

        // String auCookieValue = getAuValue(fromPageResponse.getHeaders());
        // cookiesList.add(ConstDefine.DEFAULT_AU_KEY + "=" + auCookieValue);
        //
        // if (null != ZenTaoGlobal.httpHeaders) {
        // ZenTaoGlobal.httpHeaders.clear();
        // }
        //
        // ZenTaoGlobal.httpHeaders = httpHeaders;

        ZenTaoApiResponseObject loginResulTaoApiResponseObject = JsonUtil
                .jsonToObject(loginResponseEntity.getBody(),
                        ZenTaoApiResponseObject.class);

        if (null == loginResulTaoApiResponseObject || !"success"
                .equalsIgnoreCase(loginResulTaoApiResponseObject.getStatus())) {
            throw new BusinessValidationException("禅道登录失败");
        }

        /**
         * 登录成功之后
         */
        HttpHeaders headers = loginResponseEntity.getHeaders();
        LOGGER.debug("headers:{}", headers);
        ZenTaoGlobal.httpHeaders = headers;

        this.zenTaoSessionId = sessionId;
    }

    /**
     * 登陆
     * 
     * @see :
     * @param :
     * @return : void
     * @param zentaoServerUrl
     * @param username
     * @param password
     */
    public void login(ZenTaoServerInfo zenTaoServerInfo) {
        login(zenTaoServerInfo.getZenTaoServerUrl(),
                zenTaoServerInfo.getLoginUsername(),
                zenTaoServerInfo.getLoginPassword());
    }

    /**
     * 登陆
     * 
     * @see :
     * @param :
     * @return : void
     * @param zentaoServerUrl
     * @param username
     * @param password
     */
    public void login() {
        login(this.zenTaoServerInfo);
    }

    private HttpHeaders getDefaultHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        return httpHeaders;
    }

    private List<String> getHeaderValueByHeaderKeyFromHeaders(
            HttpHeaders httpHeaders, String headerKey) {
        if (null == httpHeaders || StringUtil.isEmpty(headerKey)) {
            return new ArrayList<String>();
        }
        Set<Map.Entry<String, List<String>>> entries = httpHeaders.entrySet();

        Iterator iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> aEntry = (Entry<String, List<String>>) iterator
                    .next();

            if (headerKey.equals(aEntry.getKey())) {
                LOGGER.debug("获取到的:[{}]为:[{}]", headerKey, aEntry.getValue());
                return aEntry.getValue();
            }
        }
        return new ArrayList<>();
    }

    private List<String> getSetCookieValue(HttpHeaders httpHeaders) {
        return getHeaderValueByHeaderKeyFromHeaders(httpHeaders, "Set-Cookie");
    }

    private Map<String, String> getKeyValuePairesFromSetCookies(
            List<String> setCookies) {
        String eachSetCookieValue = null;

        Map<String, String> setCookieValuePairs = new HashMap<>();
        for (int i = 0; i < setCookies.size(); i++) {
            eachSetCookieValue = setCookies.get(i);
            LOGGER.debug("eachSetCookie:{}", eachSetCookieValue);
            // int fromIndex = (cookieKey + "=").length();
            // int endIndex = eachSetCookieValue.indexOf(";");
            // String cookieValue = eachSetCookieValue.substring(fromIndex,
            // endIndex);
            // LOGGER.debug("获取到cookie:{},的值为:{}", cookieKey, cookieValue);
            // 有keyvalue的标志，且有
            String[] cookieDetails = eachSetCookieValue.split(";");
            for (String string : cookieDetails) {
                if (!string.contains("=")) {
                    continue;
                }

                String[] keyValuePair = string.split("=");
                String key;
                String value;
                key = keyValuePair[0];
                if (keyValuePair.length == 1) {

                    value = null;
                } else {
                    value = keyValuePair[1];
                }

                setCookieValuePairs.put(key, value);
            }
        }

        LOGGER.debug("setCookieValuePairs:{}", setCookieValuePairs);
        return setCookieValuePairs;
    }

    private String getCookieValueByCookieKeyFromSetCookies(
            List<String> setCookies, String cookieKey) {
        String eachSetCookieValue = null;
        for (int i = 0; i < setCookies.size(); i++) {
            eachSetCookieValue = setCookies.get(i);
            LOGGER.debug("eachSetCookie:{}", eachSetCookieValue);
            if (eachSetCookieValue.contains(cookieKey + "=")) {
                int fromIndex = (cookieKey + "=").length();
                int endIndex = eachSetCookieValue.indexOf(";");
                String cookieValue = eachSetCookieValue.substring(fromIndex,
                        endIndex);
                LOGGER.debug("获取到cookie:{},的值为:{}", cookieKey, cookieValue);
                return cookieValue;
            }
        }
        return null;
    }

    private void displayHeaders(HttpHeaders httpHeaders) {
        if (null == httpHeaders) {
            return;
        }
        Set<Map.Entry<String, List<String>>> entries = httpHeaders.entrySet();
        Iterator iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> aEntry = (Entry<String, List<String>>) iterator
                    .next();
            LOGGER.debug("headerKey:[{}]的headerValue为:[{}]", aEntry.getKey(),
                    aEntry.getValue());
        }
    }

    /**
     * 可以在不登录情况下发送的get请求
     * 
     * @see :
     * @param :
     * @return : ResponseEntity<String>
     * @return
     */
    public ResponseEntity<String> getWithOutLogin(String url) {
        String finalUrl = ZenTaoUtil.dealWithUrl(url, this.zenTaoServerInfo);
        ResponseEntity<String> responseEntity = RestTemplateFactory
                .getRestTemplate().getForEntity(finalUrl, String.class);

        if (null != responseEntity
                && !StringUtil.isEmpty(responseEntity.getBody())) {
            LOGGER.debug("response:{}", responseEntity);
            LOGGER.debug("responseText:{}", responseEntity.getBody());
        }
        return responseEntity;
    }

    /**
     * 可以在不登录情况下发送的post
     * 
     * @see :
     * @param :
     * @return : ResponseEntity<String>
     * @return
     */
    public ResponseEntity<String> postWithOutLogin(String url,
            Map<String, String> postMap) {
        String finalUrl = ZenTaoUtil.dealWithUrl(url, this.zenTaoServerInfo);

        MultiValueMap<String, String> postMultiParams = ParamsKeyValueUtil
                .changeMapToMultiValueMap(postMap);

        ResponseEntity<String> responseEntity = RestTemplateFactory
                .getRestTemplate()
                .postForEntity(finalUrl, postMultiParams, String.class);

        if (null != responseEntity
                && !StringUtil.isEmpty(responseEntity.getBody())) {
            LOGGER.debug("response:{}", responseEntity);
            LOGGER.debug("responseText:{}", responseEntity.getBody());
        }
        return responseEntity;
    }

    /**
     * 可以在不登录情况下发送的get请求
     * 
     * @see :
     * @param :
     * @return : ResponseEntity<String>
     * @return
     */
    public ResponseEntity<String> getWithLogin(String url) {
        LOGGER.debug("发送get请求，请求url:{}", url);
        ResponseEntity<String> responseEntity = client(url, HttpMethod.GET,
                null);

        if (null != responseEntity
                && !StringUtil.isEmpty(responseEntity.getBody())) {
            LOGGER.debug("response:{}", responseEntity);
            LOGGER.debug("responseText:{}", responseEntity.getBody());
            LOGGER.debug("responseTextAfterDeal:{}",
                    dealWithResponseData(responseEntity.getBody()));
        }

        return responseEntity;
    }

    /**
     * 可以在不登录情况下发送的get请求
     * 
     * @see :
     * @param :
     * @return : ResponseEntity<String>
     * @return
     */
    public ResponseEntity<String> getWithLogin(String url,
            Map<String, String> params) {
        LOGGER.debug("发送get请求，请求url:{},请求内容:{}", url, params);
        ResponseEntity<String> responseEntity = client(url, HttpMethod.GET,
                ParamsKeyValueUtil.changeMapToMultiValueMap(params));

        if (null != responseEntity
                && !StringUtil.isEmpty(responseEntity.getBody())) {
            LOGGER.debug("response:{}", responseEntity);
            LOGGER.debug("responseText:{}", responseEntity.getBody());
        }
        return responseEntity;
    }

    /**
     * 可以在不登录情况下发送的post
     * 
     * @see :
     * @param :
     * @return : ResponseEntity<String>
     * @return
     */
    public ResponseEntity<String> postWithLogin(String url,
            Map<String, String> postMap) {
        LOGGER.debug("发送post请求，请求url:{},请求内容:{}", url, postMap);
        MultiValueMap<String, String> postMultiParams = ParamsKeyValueUtil
                .changeMapToMultiValueMap(postMap);

        ResponseEntity<String> responseEntity = client(url, HttpMethod.POST,
                postMultiParams);

        if (null != responseEntity
                && !StringUtil.isEmpty(responseEntity.getBody())) {
            LOGGER.debug("response:{}", responseEntity);
            LOGGER.debug("responseText:{}", responseEntity.getBody());
        }

        return responseEntity;
    }

    /**
     * 获取sessionID
     * 
     * @see :
     * @param :
     * @return : ZenTaoApiResponseObject
     * @return
     */
    public ZenTaoApiResponseObject getSessionId() {
        ResponseEntity<String> responseEntity = null;

        try {
            responseEntity = getWithOutLogin(
                    RequestAction.GET_SESSION_ID_ACTION);
            return ZenTaoUtil.parseZenTaoApiResponseObjectFromResponseText(
                    responseEntity.getBody());
        } catch (ResourceAccessException e) {
            LOGGER.error("请求出错了:{}", e.getMessage());
            throw new BusinessValidationException("当前配置地址可能连接不上，请检查地址是否正确");
        } catch (Exception e) {
            throw new BusinessValidationException("出现了异常，访问禅道失败");
        }
    }

    /**
     * 获取基本响应头
     * 
     * @see :
     * @param :
     * @return : HttpHeaders
     * @return
     */
    public HttpHeaders getBasicHttpHeaders() {

        LOGGER.debug("当前的请求头为:{}", ZenTaoGlobal.httpHeaders);
        // if (null == ZenTaoGlobal.httpHeaders
        // || ZenTaoGlobal.httpHeaders.isEmpty()) {
        //
        // LOGGER.debug("当前尚未存在登录认证,需先登录");
        // login(this.zenTaoServerInfo);
        // }

        login(this.zenTaoServerInfo);

        MultiValueMap<String, String> postHeaders = new LinkedMultiValueMap<>();

        // Set<Map.Entry<String, List<String>>> entries =
        // httpHeaders.entrySet();
        // for (Map.Entry<String, List<String>> eachEntry : entries) {
        // postHeaders.put(eachEntry.getKey(), eachEntry.getValue());
        // }

        Map<String, String> setCookieKeyValuePairs = getKeyValuePairesFromSetCookies(
                getSetCookieValue(ZenTaoGlobal.httpHeaders));

        List<String> cookieValueBuilder = new ArrayList<String>();

        for (Map.Entry<String, String> eachEntry : setCookieKeyValuePairs
                .entrySet()) {
            // postHeaders.put(eachEntry.getKey(),
            // Arrays.asList(eachEntry.getValue()));
            cookieValueBuilder
                    .add(eachEntry.getKey() + "=" + eachEntry.getValue() + ";");
        }

        postHeaders.put("Cookie", cookieValueBuilder);
        LOGGER.debug("postHeaders:{}", postHeaders);
        postHeaders.put("Content-type",
                Arrays.asList(MediaType.APPLICATION_JSON.toString()));
        HttpHeaders finalPostHttpHeaders = new HttpHeaders(postHeaders);
        return finalPostHttpHeaders;
    }

    /**
     * 
     * @see :
     * @param :
     * @return : ResponseEntity<String>
     * @param url
     * @param method
     * @param params
     * @return
     */
    private ResponseEntity<String> client(String url, HttpMethod method,
            MultiValueMap<String, String> params) {
        HttpHeaders httpHeaders = getBasicHttpHeaders();

        if (null != this.zenTaoSessionId
                && StringUtil.isStringAvaliable(this.zenTaoSessionId)) {
            if (url.contains("?")) {
                url += "&zentaosid=" + this.zenTaoSessionId;
            } else {
                url += "?zentaosid=" + this.zenTaoSessionId;
            }
        }
        LOGGER.debug("发送请求，请求url:{},请求方式:{},请求内容:{}", url, method, params);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
                params, httpHeaders);
        String finalUrl = ZenTaoUtil.dealWithUrl(url, this.zenTaoServerInfo);
        LOGGER.debug("请求URL：{}", finalUrl);
        LOGGER.debug("请求参数:{},requestEntity:{}", params, requestEntity);
        ResponseEntity<String> responseEntity = RestTemplateFactory
                .getRestTemplate()
                .exchange(finalUrl, method, requestEntity, String.class);
        LOGGER.debug("请求结果:{}", responseEntity.getBody());

        if (!responseEntity.getBody().isEmpty()
                && responseEntity.getBody().startsWith("<html>")) {
            LOGGER.error("返回值出错了，需要重新登录，清除当前头 ");
            //
            // if (null != ZenTaoGlobal.httpHeaders) {
            // ZenTaoGlobal.httpHeaders.clear();
            // }

            ZenTaoGlobal.httpHeaders = null;
            login(this.zenTaoServerInfo);

            return null;
        }

        return responseEntity;
    }

    /**
     * 处理转义字符
     * 
     * @see :
     * @param :
     * @return : String
     * @param response
     * @return
     */
    private String dealWithResponseData(String response) {
        if (response.isEmpty()) {
            return "";
        }
        return response.replace("\\\"", "\"").replace("\"{", "{").replace("}\"",
                "}");
    }
}

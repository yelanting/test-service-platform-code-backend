package com.testservice.platform.server.page;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.testservice.platform.util.core.StringUtil;

/**
 * 分页请求
 * 
 * @author Administrator
 * @date Jan 12, 2019
 */
public class PageRequest {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PageRequest.class);
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页数量
     */
    private int pageSize = 10;
    /**
     * 查询参数
     */
    private List<Param> params = new ArrayList<>();

    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * 查询参数对象
     * 
     * @param name
     *            参数名称
     * @return
     */
    public Param getParam(String name) {
        Param foundParam = null;
        for (Param param : this.params) {
            if (name != null && name.equals(param.getName())
                    && StringUtil.isStringAvaliable(param.getValue())) {
                foundParam = param;
            }
        }

        LOGGER.debug("分页请求参数为:{}", foundParam);
        return foundParam;
    }

    /**
     * 查询参数值
     * 
     * @param name
     *            参数名称
     * @return
     */
    public String getParamValue(String name) {
        Param param = getParam(name);
        if (param != null) {
            return param.getValue();
        }
        return null;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Param> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "PageRequest [pageNum=" + pageNum + ", pageSize=" + pageSize
                + ", params=" + params + "]";
    }

}

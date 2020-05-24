package com.testservice.platform.server.page;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.testservice.platform.util.core.ReflectionUtils;

/**
 * MyBatis 分页查询助手
 * 
 * @author Administrator
 * @date Jan 12, 2019
 */
public class MybatisPageHelper {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MybatisPageHelper.class);

    public static final String FIND_PAGE = "findPage";

    /**
     * 分页查询, 约定查询方法名为 “findPage”
     * 
     * @param pageRequest
     *            分页请求
     * @param mapper
     *            Dao对象，MyBatis的 Mapper
     * @param args
     *            方法参数
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, FIND_PAGE);
    }

    /**
     * 调用分页插件进行分页查询
     * 
     * @param pageRequest
     *            分页请求
     * @param mapper
     *            Dao对象，MyBatis的 Mapper
     * @param queryMethodName
     *            要分页的查询方法名
     * @param args
     *            方法参数
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static PageResult findPage(PageRequest pageRequest, Object mapper,
            String queryMethodName, Object... args) {
        // 设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        LOGGER.debug("分页查询参数:pageNum:{},pageSize:{}", pageNum, pageSize);
        PageMethod.startPage(pageNum, pageSize);
        // 利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        LOGGER.debug("反射调用结果为:{}", result);

        PageInfo pageInfo = new PageInfo<>((List) result);
        return getPageResult(pageRequest, pageInfo);
    }

    /**
     * 将分页信息封装到统一的接口
     * 
     * @param pageRequest
     * @param page
     * @return
     */
    private static PageResult getPageResult(PageRequest pageRequest,
            PageInfo<?> pageInfo) {
        LOGGER.debug("pageInfo:{}", pageInfo);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        // pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        LOGGER.debug("pageResult:{}", pageResult);
        return pageResult;
    }

    /**
     * 将分页信息封装到统一的接口
     * 
     * @param pageRequest
     * @param page
     * @return
     */
    public static PageResult parsePageResultFromPageInfo(
            PageRequest pageRequest, PageInfo<?> pageInfo) {
        LOGGER.debug("parsePageResultFromPageInfo pageInfo:{}", pageInfo);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        // pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        LOGGER.debug("parsePageResultFromPageInfo pageResult:{}", pageResult);
        return pageResult;
    }

}

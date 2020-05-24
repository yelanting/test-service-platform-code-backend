package com.testservice.platform.server.page;

import java.util.List;

/**
 * 分页返回结果
 * 
 * @author Administrator
 * @date Jan 12, 2019
 */
public class PageResult {
    /**
     * 默认每页数量
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认页数
     */
    public static final int PAGE_COUNT = 10;

    /**
     * 是否全量更新
     */
    private boolean full = false;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页数量
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 记录总数
     */
    private long totalSize = 0;
    /**
     * 页码总数
     */
    private int totalPages = 0;
    /**
     * 分页数据
     */
    private List<?> content;

    /**
     * 起始行,通常通过pageNo和pageSize计算得到
     */
    private int dbIndex = 0;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        // 设置页码的时候
        int temp = (pageNum - 1) < 0 ? 0 : (pageNum - 1);
        this.dbIndex = temp * this.pageSize;
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        // 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        this.totalSize = totalSize;

        long totalPageCount = (this.totalSize % this.pageSize == 0)
                ? this.totalSize / this.pageSize
                : ((this.totalSize / this.pageSize) + 1);

        this.setTotalPages((int) (totalPageCount));
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageResult [full=" + full + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize + ", totalSize=" + totalSize
                + ", totalPages=" + totalPages + ", content=" + content + "]";
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}

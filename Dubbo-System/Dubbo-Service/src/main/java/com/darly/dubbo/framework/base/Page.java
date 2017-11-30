package com.darly.dubbo.framework.base;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/14 16:35
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public class Page implements java.io.Serializable {
    public static final int DEFAULT_PAGE_SIZE = 15;
    public static final int MAX_PAGE_SIZE = 100;

    /**
     * 每页的记录数，实际记录数小于或等于它
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 当前页第几条数据在数据库中的位置
     */
    private int start;
    /**
     * 当前页包含的记录数，avaCount <= pageSize
     */
    private int avaCount;
    /**
     * 总记录数
     */
    private int totalSize;
    /**
     * 当前页中存放的数据
     */
    private List data;
    /**
     * 当前页码
     */
    private int currentPageNo;
    /**
     * 总页数
     */
    private int totalPageCount;

    /**
     * 构造方法
     */
    public Page() {
        this(0, 0, 0, DEFAULT_PAGE_SIZE, new ArrayList<Object>());
    }

    /**
     * 默认构造方法
     *
     * @param start     本页数据在数据库中的起始位置
     * @param avaCount  本页的实际数据条数
     * @param totalSize 数据库中总记录条数
     * @param pageSize  本页容量
     * @param data      本页包含的数据
     */
    public Page(int start, int avaCount, int totalSize, int pageSize, List data) {
        this.avaCount = avaCount;
        this.pageSize = pageSize;
        this.start = start;
        this.totalSize = totalSize;
        this.data = data;

        this.currentPageNo = (start - 1) / pageSize + 1;
        this.totalPageCount = (totalSize + pageSize - 1) / pageSize;
        if (totalSize == 0 && avaCount == 0) {
            this.currentPageNo = 1;
            this.totalPageCount = 1;
        }
    }

    /**
     * 当前页中的记录
     */
    public List getResult() {
        return this.data;
    }

    /**
     * 取本页数据容量（本页能包含的记录数）
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 是否有下一页
     */
    public boolean hasNextPage() {
        return (this.getCurrentPageNo() < this.getTotalPageCount());
    }

    /**
     * 是否有上一页
     */
    public boolean hasPreviousPage() {
        return (this.getCurrentPageNo() > 1);
    }

    /**
     * 获取当前页第一条数据在数据库中的位置
     */
    public int getStart() {
        return start;
    }

    /**
     * 获取当前页最后一条数据在数据库中的位置
     */
    public int getEnd() {
        int end = this.getStart() + this.getSize() - 1;
        if (end < 0)
            end = 0;
        return end;
    }

    /**
     * 获取上一页第一条数据在数据库中的位置
     */
    public int getStartOfPreviousPage() {
        return Math.max(start - pageSize, 1);
    }

    /**
     * 获取下一页第一条数据在数据库中的位置
     */
    public int getStartOfNextPage() {
        return start + avaCount;
    }

    /**
     * 获取任一页第一条数据在数据库中的位置，每页条数使用默认DEFAULT_PAGE_SIZE
     */
    public static int getStartOfAnyPage(int pageNo) {
        return getStartOfAnyPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据库中的位置
     */
    public static int getStartOfAnyPage(int pageNo, int pageSize) {
        int startIndex = (pageNo - 1) * pageSize + 1;
        if (startIndex < 1) startIndex = 1;
        return startIndex;
    }

    /***
     * 获取MyBatis的分页参数
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static RowBounds getRowBounds(int pageNo, int pageSize){
        return new RowBounds(Page.getStartOfAnyPage(pageNo, pageSize)-1,pageSize);
    }

    /***
     * 获取分页的Page对象
     * @param totalCount 总条数
     * @param records  分页记录结果
     * @param pageNo   页码
     * @param pageSize 每页条数
     * @return
     */
    public static Page getPage(int totalCount,List records,int pageNo,int pageSize){
        int avaCount = records == null ? 0 : records.size();
        if (totalCount < 1) {
            return new Page();
        }
        if (pageNo < 1) pageNo = 1;
        int startIndex = Page.getStartOfAnyPage(pageNo, pageSize);
        return new Page(startIndex, avaCount, totalCount, pageSize, records);
    }

    /**
     * 取本页包含的记录条数
     */
    public int getSize() {
        return avaCount;
    }

    /**
     * 取数据库中包含的总记录数
     */
    public int getTotalSize() {
        return this.totalSize;
    }

    /**
     * 取当前页码
     */
    public int getCurrentPageNo() {
        return this.currentPageNo;
    }

    /**
     * 取总共页数
     */
    public int getTotalPageCount() {
        return this.totalPageCount;
    }

}

package com.igl.gov.common.api;

import com.igl.gov.common.param.PageParam;

import java.util.List;


/**
 * 分页bean
 */
public class DataGridResult<T> {
    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum;
    // 总页数
    private Integer totalPage;
    // 是否有下一页
    private Integer isMore;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    public DataGridResult() {
        super();
    }

    public DataGridResult(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
    }

    public DataGridResult(Integer currentPage, Integer pageSize, Integer totalNum,List<T> items) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.items = items;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
    }

    public DataGridResult(Object object, Integer totalNum,List<T> items) {
        super();
        PageParam param = (PageParam)object;
        this.currentPage = param.getPage();
        this.pageSize = param.getPageSize();
        this.totalNum = totalNum;
        this.items = items;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getIsMore() {
        isMore = this.currentPage >= totalPage ? 0 : 1;
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getStartIndex() {
        startIndex = (this.currentPage - 1) * this.pageSize;
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

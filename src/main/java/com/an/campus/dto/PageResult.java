package com.an.campus.dto;

public class PageResult<T> extends QResult<T> {
    private T data;
    private Integer pageSize;
    private Integer pageCount;
    private Integer status;

    public PageResult(T data, Integer pageSize, Integer pageCount, Integer status) {
        super(data, status);
        this.pageSize = pageSize;
        this.pageCount = pageCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}

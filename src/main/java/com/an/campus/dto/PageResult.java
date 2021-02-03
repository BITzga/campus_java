package com.an.campus.dto;

import org.springframework.data.domain.Pageable;

public class PageResult<T> extends QResult<T> {
    private Pageable pageable;

    public PageResult(T data, Integer status, Pageable pageable) {
        super(data, status);
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
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


}

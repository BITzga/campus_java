package com.an.campus.dto;

public class UploadResult {
    private Integer status;
    private String url;

    public UploadResult(Integer status, String url) {
        this.status = status;
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

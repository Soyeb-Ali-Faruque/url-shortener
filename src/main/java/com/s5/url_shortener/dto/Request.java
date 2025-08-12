package com.s5.url_shortener.dto;

import lombok.Data;

public class Request {
    private String originalUrl;

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl(){
        return this.originalUrl;
    }
}

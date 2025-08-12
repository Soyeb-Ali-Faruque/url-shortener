package com.s5.url_shortener.dto;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

public class Response {
    private String shortUrl;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Timestamp expires;
    private String message;
    public Response(String shortUrl, Timestamp expires){
        this.shortUrl = shortUrl;
        this.expires = expires;
    }
    public  Response(String msg){
        this.message = msg;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Timestamp getExpires() {
        return expires;
    }

    public void setExpires(Timestamp expires) {
        this.expires = expires;
    }
}

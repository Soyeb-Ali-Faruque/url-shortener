package com.s5.url_shortener.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name="short_urls")

public class UrlModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String originalUrl;
    @Column(nullable = false,unique = true)
    private String ShortUrl;
    @CreationTimestamp
    private Timestamp createdAt;

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return ShortUrl;
    }

    public void setShortUrl(String shortUrl) {
        ShortUrl = shortUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastAccessedAt() {
        return lastAccessedAt;
    }

    public void setLastAccessedAt(Timestamp lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    @CreationTimestamp
    private Timestamp expiresAt;
    @UpdateTimestamp
    private Timestamp lastAccessedAt;
    @Column(nullable = false)
    private long clickCount=0;

}

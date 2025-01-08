package com.url.shortener.url.shortener.model;

public class URLMapping {
    private String originalUrl;
    private String shortUrl;

    public URLMapping(String originalUrl, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}

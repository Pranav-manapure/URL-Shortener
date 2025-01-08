package com.url.shortener.url.shortener.repository;

import com.url.shortener.url.shortener.model.URLMapping;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class URLRepository {

    private final Map<String, URLMapping> urlMap = new ConcurrentHashMap<>();
    private final Map<String, Integer> domainMetrics = new HashMap<>();

    public URLMapping save(String originalUrl, String shortUrl) {
        URLMapping mapping = new URLMapping(originalUrl, shortUrl);
        urlMap.put(shortUrl, mapping);
        domainMetrics.put(getDomainName(originalUrl),
                domainMetrics.getOrDefault(getDomainName(originalUrl), 0) + 1);
        return mapping;
    }

    private String getDomainName(String url) {
        try {
            return new java.net.URI(url).getHost();
        } catch (Exception e) {
            return "unknown";
        }
    }

    public URLMapping findByOriginalUrl(String originalUrl) {
        return urlMap.values()
                .stream()
                .filter(mapping -> mapping.getOriginalUrl().equals(originalUrl))
                .findFirst()
                .orElse(null);
    }

}

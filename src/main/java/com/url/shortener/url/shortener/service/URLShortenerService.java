package com.url.shortener.url.shortener.service;

import com.url.shortener.url.shortener.model.URLMapping;
import com.url.shortener.url.shortener.repository.URLRepository;
import com.url.shortener.url.shortener.util.URLShortenerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class URLShortenerService {

    @Autowired
    private URLRepository urlRepository;

    private static final String BASE_URL = "localhost:8080/";

    public String shortenUrl(String originalUrl) {
        URLMapping existingMapping = urlRepository.findByOriginalUrl(originalUrl);
        if (existingMapping != null) {
            return BASE_URL + existingMapping.getShortUrl();
        }

        String shortUrl = URLShortenerUtil.generateShortUrl(originalUrl);
        urlRepository.save(originalUrl, shortUrl);
        return BASE_URL + shortUrl;
    }


    public String getOriginalUrl(String shortUrl) {
        URLMapping mapping = urlRepository.findByShortUrl(shortUrl);
        return mapping != null ? mapping.getOriginalUrl() : null;
    }

    public Map<String, Integer> getAllDomains() {
        return urlRepository.getDomainMetrics()
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue()) // Optional: Keep them sorted by count
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}

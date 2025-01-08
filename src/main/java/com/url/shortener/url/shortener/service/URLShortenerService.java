package com.url.shortener.url.shortener.service;

import com.url.shortener.url.shortener.model.URLMapping;
import com.url.shortener.url.shortener.repository.URLRepository;
import com.url.shortener.url.shortener.util.URLShortenerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

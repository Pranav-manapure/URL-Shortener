package com.url.shortener.url.shortener.controller;

import com.url.shortener.url.shortener.service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping()
public class URLShortenerController {

    @Autowired
    private URLShortenerService urlShortenerService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("originalUrl");
        String shortUrl = urlShortenerService.shortenUrl(originalUrl);
        return ResponseEntity.ok(shortUrl);
    }

}

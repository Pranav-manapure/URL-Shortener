package com.url.shortener.url.shortener.controller;

import com.url.shortener.url.shortener.service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlShortenerService.getOriginalUrl(shortUrl);
        return originalUrl != null ? ResponseEntity.status(302).location(URI.create(originalUrl)).build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/metrics/domains")
    public ResponseEntity<Map<String, Integer>> getAllDomains() {
        return ResponseEntity.ok(urlShortenerService.getAllDomains());
    }
}

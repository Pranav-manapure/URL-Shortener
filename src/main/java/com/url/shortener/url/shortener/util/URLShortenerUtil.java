package com.url.shortener.url.shortener.util;


import java.util.Base64;
import java.util.UUID;

public class URLShortenerUtil {

    public static String generateShortUrl(String originalUrl) {
        // Combine original URL with a unique identifier (UUID) to ensure uniqueness
        String uniqueString = originalUrl + UUID.randomUUID();
        // Encode the unique string using Base64 URL encoding
        String encodedString = Base64.getUrlEncoder()
                .encodeToString(uniqueString.getBytes());

        // Return the last 8 characters of the encoded string
        return encodedString.substring(encodedString.length() - 8);
    }
}

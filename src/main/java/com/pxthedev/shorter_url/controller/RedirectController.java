package com.pxthedev.shorter_url.controller;

import com.pxthedev.shorter_url.entity.URL;
import com.pxthedev.shorter_url.exception.ExpiredUrlException;
import com.pxthedev.shorter_url.exception.OriginalUrlNotFoundException;
import com.pxthedev.shorter_url.impl.RedirectImpl;
import com.pxthedev.shorter_url.impl.URLServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class RedirectController {
    private final URLServiceImpl service;
    private final RedirectImpl redirect;

    public RedirectController(URLServiceImpl service, RedirectImpl redirect) {
        this.service = service;
        this.redirect = redirect;
    }

    @GetMapping
    @RequestMapping("{shortUrl}")
    public ResponseEntity<Void> redirect (@PathVariable("shortUrl") String shortUrl) {
        URL originalUrl = service.getOriginalURL(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        boolean isExpired = originalUrl.getExpiresAt().isBefore(LocalDateTime.now());
        if (isExpired) {
            throw new ExpiredUrlException();
        }

        boolean valid = redirect.isValidURL(originalUrl.getOriginalURL());
        if (valid) {
            return ResponseEntity
                    .status(HttpStatus.PERMANENT_REDIRECT)
                    .headers(headers)
                    .header("Location", originalUrl.getOriginalURL())
                    .build();
        }

        throw new OriginalUrlNotFoundException("Couldn't reach out to informed URL");
    }
}

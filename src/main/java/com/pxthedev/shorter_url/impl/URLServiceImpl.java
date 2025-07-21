package com.pxthedev.shorter_url.impl;

import com.pxthedev.shorter_url.entity.URL;
import com.pxthedev.shorter_url.repository.URLRepository;
import com.pxthedev.shorter_url.services.URLService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class URLServiceImpl implements URLService {
    private final URLRepository repository;

    public URLServiceImpl(URLRepository repository) {
        this.repository = repository;
    }

    @Override
    public URL getOriginalURL(String shortURL) {
        return null;
    }

    @Override
    public URL createShortURL(String originalURL) {
        URL source = new URL();
        source.setOriginalURL(originalURL);
        source.setViews(0);
        source.setShortURL(generateShort());
        source.setExpiresAt(LocalDateTime.now().plusDays(2));
        repository.save(source);

        return source;
    }

    private String generateShort(){
        return RandomStringUtils.randomAlphanumeric(4, 12);
    }
}

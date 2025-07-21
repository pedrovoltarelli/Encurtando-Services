package com.pxthedev.shorter_url.services;

import com.pxthedev.shorter_url.entity.URL;
import org.springframework.stereotype.Service;

@Service
public interface URLService {
    URL getOriginalURL(String shortURL);
    URL createShortURL(String originalURL);
}

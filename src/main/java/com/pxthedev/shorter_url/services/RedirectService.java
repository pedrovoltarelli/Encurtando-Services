package com.pxthedev.shorter_url.services;

import org.springframework.stereotype.Service;

@Service
public interface RedirectService {
    boolean isValidURL(String url);
}

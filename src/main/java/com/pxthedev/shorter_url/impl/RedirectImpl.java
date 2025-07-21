package com.pxthedev.shorter_url.impl;

import com.pxthedev.shorter_url.services.RedirectService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

@Service
public class RedirectImpl implements RedirectService {
    
    @Override
    public boolean isValidURL(String url) {
        try {
            int code = 0;
            URI urlObj = new URI(url);
            URLConnection conn = urlObj.toURL().openConnection();
            if (conn instanceof HttpURLConnection httpConn) {
                httpConn.setRequestMethod("HEAD");
                httpConn.setConnectTimeout(3000);
                code = httpConn.getResponseCode();
            }
            return code >= 200 && code < 400;
        } catch (URISyntaxException | IOException | IllegalArgumentException ex) {
            return false;
        }
    }
}

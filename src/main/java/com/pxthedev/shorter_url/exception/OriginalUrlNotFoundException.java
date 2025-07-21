package com.pxthedev.shorter_url.exception;

public class OriginalUrlNotFoundException extends RuntimeException {
    public OriginalUrlNotFoundException(String msg){
        super(msg);
    }
}

package com.pxthedev.shorter_url.exception;

public class ExpiredUrlException extends RuntimeException{
    public ExpiredUrlException(){
        super("Url expirada.");
    }
}

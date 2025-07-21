package com.pxthedev.shorter_url.controller;

import com.pxthedev.shorter_url.dto.URLDto;
import com.pxthedev.shorter_url.dto.URLResponseDto;
import com.pxthedev.shorter_url.entity.URL;
import com.pxthedev.shorter_url.impl.URLServiceImpl;
import com.pxthedev.shorter_url.mapper.URLMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class URLController {
    private final URLMapper mapper;
    private final URLServiceImpl service;

    public URLController(URLMapper mapper, URLServiceImpl service) {
        this.mapper = mapper;
        this.service = service;
    }

    public ResponseEntity<URLDto> createURL(@RequestBody URLDto dto){
        URL source = service.createShortURL(dto.URL());
        URLResponseDto responseDto = mapper.toResponseDto(source);
        return ResponseEntity.status(200).body(dto);
    }
}

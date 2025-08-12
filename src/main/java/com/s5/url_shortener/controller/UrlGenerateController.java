package com.s5.url_shortener.controller;

import com.s5.url_shortener.dto.Request;
import com.s5.url_shortener.dto.Response;
import com.s5.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1")
public class UrlGenerateController {
    @Autowired
    UrlService service;

    @PostMapping("/generate")
    public ResponseEntity<Response> getShortUrl(@RequestBody Request request){
        String url = request.getOriginalUrl();
        Response response = service.generateShortUrl(url);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }







}

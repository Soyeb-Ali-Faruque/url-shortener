package com.s5.url_shortener.service;

import com.s5.url_shortener.dto.Response;
import com.s5.url_shortener.model.UrlModel;
import com.s5.url_shortener.repository.UrlRepository;
import com.s5.url_shortener.util.Base62Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UrlService {
        @Autowired
        private UrlRepository repository;
        public Response generateShortUrl(String url){
                String shortUrl="http://localhost:8080/";
                Timestamp expires = Timestamp.valueOf(LocalDateTime.now().plusDays(15));
                UrlModel instance = new UrlModel();
                instance.setOriginalUrl(url);
                instance.setShortUrl(shortUrl);
                instance.setExpiresAt(expires);

                UrlModel savedInstance = repository.save(instance);

                shortUrl += Base62Encoder.encode(savedInstance.getId() + 1000000);
                savedInstance.setShortUrl(shortUrl);

                repository.save(savedInstance);

                return new Response(shortUrl,expires);
        }

        public String getOriginalUrl(String shortCode){
                return repository.findOriginalUrlByShortUrlEndingWith(shortCode);
        }
}

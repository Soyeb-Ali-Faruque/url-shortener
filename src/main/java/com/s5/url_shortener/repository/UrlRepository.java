package com.s5.url_shortener.repository;

import com.s5.url_shortener.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UrlRepository extends JpaRepository<UrlModel,Long> {
    @Query(value = "SELECT original_url FROM `url-shortener`.short_urls WHERE short_url LIKE %:suffix LIMIT 1", nativeQuery = true)
    String findOriginalUrlByShortUrlEndingWith(@Param("suffix") String suffix);


}

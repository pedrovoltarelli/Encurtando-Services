package com.pxthedev.shorter_url.repository;

import com.pxthedev.shorter_url.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortURL(String shortURL);
}

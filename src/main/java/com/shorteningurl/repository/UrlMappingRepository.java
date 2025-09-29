package com.shorteningurl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shorteningurl.entity.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
	Optional<UrlMapping> findByShortCode(String shortCode);
}

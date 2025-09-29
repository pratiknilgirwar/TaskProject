package com.shorteningurl.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shorteningurl.dto.UrlShortenResponse;
import com.shorteningurl.dto.UrlShortening;
import com.shorteningurl.entity.UrlMapping;
import com.shorteningurl.repository.UrlMappingRepository;
import com.shorteningurl.util.Base62Encoder;

@Service
public class UrlShortenerService {

	@Autowired
	private UrlMappingRepository repository;

	@Transactional
	public UrlShortenResponse shortenUrl(UrlShortening request) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiresAt = (request.getExpireInSeconds() == null || request.getExpireInSeconds() <= 0) ? null
				: now.plusSeconds(request.getExpireInSeconds());

		UrlMapping mapping = new UrlMapping();
		mapping.setOriginalUrl(request.getUrl());
		mapping.setCreatedAt(now);
		mapping.setExpiresAt(expiresAt);

		UrlMapping saved = repository.save(mapping);

		String shortCode = Base62Encoder.encode(saved.getId());
		saved.setShortCode(shortCode);
		repository.save(saved);

		return new UrlShortenResponse(shortCode, saved.getOriginalUrl());
	}

	public String getOriginalUrl(String shortCode) {
		return repository.findByShortCode(shortCode).filter(mapping -> !mapping.isExpired())
				.map(UrlMapping::getOriginalUrl).orElse(null);
	}
}

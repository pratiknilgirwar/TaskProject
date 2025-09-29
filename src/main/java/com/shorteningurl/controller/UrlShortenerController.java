package com.shorteningurl.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shorteningurl.dto.UrlShortenResponse;
import com.shorteningurl.dto.UrlShortening;
import com.shorteningurl.service.UrlShortenerService;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

	@Autowired
	private UrlShortenerService service;

	@PostMapping("/shorten")
	public ResponseEntity<UrlShortenResponse> shorten(@RequestBody UrlShortening request) {
		UrlShortenResponse resp = service.shortenUrl(request);
		return ResponseEntity.ok(resp);
	}

	@GetMapping("/{shortCode}")
	public ResponseEntity<?> redirect(@PathVariable String shortCode) {
		String originalUrl = service.getOriginalUrl(shortCode);
		if (originalUrl == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ \"error\": \"URL not found or expired\" }");
		}
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
	}
}

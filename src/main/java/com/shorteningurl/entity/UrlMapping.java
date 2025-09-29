package com.shorteningurl.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "url_mapping")
public class UrlMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "original_url", nullable = false, length = 2048)
	private String originalUrl;

	@Column(name = "short_code", unique = true)
	private String shortCode;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "expires_at")
	private LocalDateTime expiresAt;

	// Constructors
	public UrlMapping() {
	}

	public UrlMapping(String originalUrl, LocalDateTime createdAt, LocalDateTime expiresAt) {
		this.originalUrl = originalUrl;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public boolean isExpired() {
		if (expiresAt == null) {
			return false;
		}
		return LocalDateTime.now().isAfter(expiresAt);
	}
}

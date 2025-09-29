package com.shorteningurl.dto;

public class UrlShortenResponse {
	private String shortCode;
	private String originalUrl;

	public UrlShortenResponse() {
	}

	public UrlShortenResponse(String shortCode, String originalUrl) {
		this.shortCode = shortCode;
		this.originalUrl = originalUrl;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
}

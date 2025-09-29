package com.shorteningurl.dto;

public class UrlShortening {

	private String url;

	private Long expireInSeconds = 3600L;

	public UrlShortening() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getExpireInSeconds() {
		return expireInSeconds;
	}

	public void setExpireInSeconds(Long expireInSeconds) {
		this.expireInSeconds = expireInSeconds;
	}
}

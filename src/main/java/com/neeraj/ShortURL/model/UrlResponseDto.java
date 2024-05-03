package com.neeraj.ShortURL.model;

import java.time.LocalDateTime;

public class UrlResponseDto {
    private String originalUrl;
    private String shortLink;
    private String shortLinkwith_localhost;
    private LocalDateTime expirationDate;

    public UrlResponseDto(String originalUrl, String shortLink, String shortLinkwith_localhost, LocalDateTime expirationDate) {
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.shortLinkwith_localhost = shortLinkwith_localhost;
        this.expirationDate = expirationDate;
    }

    public UrlResponseDto() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getShortLinkwith_localhost() {
        return shortLinkwith_localhost;
    }

    public void setShortLinkwith_localhost(String shortLinkwith_localhost) {
        this.shortLinkwith_localhost = shortLinkwith_localhost;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", shortLinkwith_localhost='" + shortLinkwith_localhost + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}

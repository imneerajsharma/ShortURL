package com.neeraj.ShortURL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.time.LocalDateTime;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private long Id;
    @Lob
    private String originalUrl;
    private String shortLink;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    public Url(long id, String originalUrl, String shortLink, LocalDateTime creationDate, LocalDateTime expirationDate) {
        Id = id;
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Url{" +
                "Id=" + Id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
















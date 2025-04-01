package com.neeraj.ShortURL.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
public class Url {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;
    @Lob
    private String originalUrl;
    private String shortLink;
    private String shortLinkwith_localhost;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    public Url(long id, String originalUrl, String shortLink, String shortLinkwith_localhost, LocalDateTime creationDate, LocalDateTime expirationDate) {
        Id = id;
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.shortLinkwith_localhost = shortLinkwith_localhost;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }



    public Url() {
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

    public String getShortLinkwith_localhost() {
        return shortLinkwith_localhost;
    }

    public void setShortLinkwith_localhost(String shortLinkwith_localhost) {
        this.shortLinkwith_localhost = shortLinkwith_localhost;
    }

    @Override
    public String toString() {
        return "Url{" +
                "Id=" + Id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", shortLinkwith_localhost='" + shortLinkwith_localhost + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
















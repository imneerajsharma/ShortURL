package com.neeraj.ShortURL.model;

public class UrlDto {
    private String url;
    private String expirationDate;  //optional
    private String shortLinkwith_localhost;

    public UrlDto(String url, String expirationDate, String shortLinkwith_localhost) {
        this.url = url;
        this.expirationDate = expirationDate;
        this.shortLinkwith_localhost = shortLinkwith_localhost;
    }

    public UrlDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
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
        return "UrlDto{" +
                "url='" + url + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", shortLinkwith_localhost='" + shortLinkwith_localhost + '\'' +
                '}';
    }
}

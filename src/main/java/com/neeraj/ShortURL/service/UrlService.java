package com.neeraj.ShortURL.service;

import com.neeraj.ShortURL.model.Url;
import com.neeraj.ShortURL.model.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortLink(UrlDto urlDto);
    public Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortLink(Url url);
}

package com.neeraj.ShortURL.service;

import com.google.common.hash.Hashing;
import com.neeraj.ShortURL.model.Url;
import com.neeraj.ShortURL.model.UrlDto;
import com.neeraj.ShortURL.repository.UrlRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class UrlServiceImpl implements UrlService{

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if(StringUtils.isNotEmpty(urlDto.getUrl()))
        {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setShortLinkwith_localhost("http://localhost:8080/"+encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),urlToPersist.getCreationDate()));
            Url urlToRet = persistShortLink(urlToPersist);

            if(urlToRet != null)
                return urlToRet;

            return null;
        }
        return null;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if(StringUtils.isBlank(expirationDate))
        {
            return creationDate.plusSeconds(60);
        }
        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;
    }
//    private String encodeUrl(String url) {
//        String prefix = "http://localhost:8080/"; // Replace "example.com" with your domain
//        String encodedUrl = "";
//        LocalDateTime time = LocalDateTime.now();
//        String hash = Hashing.murmur3_32()
//                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
//                .toString();
//        // Extract the last 8 characters from the hash as the short code
//        String shortCode = hash.substring(hash.length() - 8);
//        encodedUrl = prefix + shortCode;
//        return encodedUrl;
//    }

//    private String encodeUrl2(String url) {
//        String prefix = "http://localhost:8080/";
//        String encodedUrl = "";
//        LocalDateTime time = LocalDateTime.now();
//        encodedUrl = prefix + Hashing.murmur3_32()
//                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
//                .toString();
//        System.out.println(encodedUrl);
//        return  encodedUrl;
//    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        System.out.println(encodedUrl);

        return  encodedUrl;
    }


    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }
}

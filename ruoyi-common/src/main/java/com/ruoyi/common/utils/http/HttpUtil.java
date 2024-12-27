package com.ruoyi.common.utils.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public final class HttpUtil {

    private static final RestTemplate restTemplate = new RestTemplate();

    // 发送GET请求
    public static <T> T get(String url, Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.getForEntity(url, responseType);
        return response.getBody();
    }

    // 发送POST请求，带有请求体
    public static <T, R> R post(String url, T request, Class<R> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<T> entity = new HttpEntity<>(request, headers);
        ResponseEntity<R> response = restTemplate.postForEntity(url, entity, responseType);
        return response.getBody();
    }

    // 发送PUT请求，带有请求体
    public static <T, R> R put(String url, T request, Class<R> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<T> entity = new HttpEntity<>(request, headers);
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.PUT, entity, responseType);
        return response.getBody();
    }

    // 发送DELETE请求
    public static void delete(String url) {
        restTemplate.delete(url);
    }
}

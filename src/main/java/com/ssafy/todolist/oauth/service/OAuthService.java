package com.ssafy.todolist.oauth.service;

import com.ssafy.todolist.oauth.dto.AuthDTO;
import com.ssafy.todolist.oauth.dto.AuthSuccessResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuthService {

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.token-uri}")
    private String tokenUri;

    private final RestTemplate restTemplate;

    public OAuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AuthSuccessResponse getTokens(AuthDTO authDTO){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", clientId);
        body.add("redirect_uri", redirectUri);
        body.add("code", authDTO.getCode());

        AuthSuccessResponse authSuccessResponse = restTemplate.postForObject(
                tokenUri,
                new HttpEntity<>(body, headers),
                AuthSuccessResponse.class
        );

        return authSuccessResponse;
    }

    public void getUserInfo(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        headers.add("Authorization", "Bearer "+token);

        ResponseEntity<String> response =
                restTemplate.exchange("https://kapi.kakao.com/v2/user/me",
                        HttpMethod.GET,
                        new HttpEntity<>(null, headers),
                        String.class);

        String body = response.getBody();
        System.out.println(body);
    }

}

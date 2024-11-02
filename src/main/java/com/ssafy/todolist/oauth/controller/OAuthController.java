package com.ssafy.todolist.oauth.controller;

import com.ssafy.todolist.oauth.dto.AuthDTO;
import com.ssafy.todolist.oauth.dto.AuthFailResponse;
import com.ssafy.todolist.oauth.dto.AuthSuccessResponse;
import com.ssafy.todolist.oauth.service.OAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth/authorization")
public class OAuthController {

    private final OAuthService oAuthService;

    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> getAuthCode(@RequestBody AuthDTO authDTO) {
        if (authDTO.getCode() == null) {
            return ResponseEntity.badRequest().body(new AuthFailResponse());
        }

        return ResponseEntity.ok(oAuthService.getTokens(authDTO));
    }
}

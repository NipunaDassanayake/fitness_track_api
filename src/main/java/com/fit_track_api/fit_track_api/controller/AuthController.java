package com.fit_track_api.fit_track_api.controller;

import com.fit_track_api.fit_track_api.model.User;
import com.fit_track_api.fit_track_api.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@RestController

public class AuthController {

    private final UserService userService;


    @GetMapping
    public String hello(){
        return "Welcome to fit track";
    }

    @GetMapping("/login/google")
    public ResponseEntity<String> loginGoogleAuth(HttpServletResponse response) throws IOException {
    response.sendRedirect("/oauth2/authorization/google");
    return ResponseEntity.ok("Redirecting.....");
    }

    @GetMapping("/loginSuccess")
    public ResponseEntity<Void> handleGoogleSuccess(OAuth2AuthenticationToken auth2AuthenticationToken) throws IOException {
        User user = userService.loginRegisterByGoogleOAuth2(auth2AuthenticationToken);

        // Encode parameters to avoid URL issues
        String email = URLEncoder.encode(user.getEmail(), StandardCharsets.UTF_8);
        String username = URLEncoder.encode(user.getUsername(), StandardCharsets.UTF_8);
        String provider = URLEncoder.encode(user.getAuthProvider().toString(), StandardCharsets.UTF_8);

        // Construct redirect URL with query parameters
        String redirectUrl = String.format("http://localhost:5173?email=%s&username=%s&provider=%s", email, username, provider);

        // Redirect to frontend with user data
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl)).build();
    }


}

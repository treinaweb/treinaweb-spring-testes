package br.com.treinaweb.twjobs.api.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.twjobs.api.auth.dtos.LoginRequest;
import br.com.treinaweb.twjobs.api.auth.dtos.MeResponse;
import br.com.treinaweb.twjobs.api.auth.dtos.TokenResponse;
import br.com.treinaweb.twjobs.api.auth.services.AuthService;
import br.com.treinaweb.twjobs.core.permissions.TWJobsPermissions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("/me")
    @TWJobsPermissions.IsAuthenticated
    public MeResponse me() {
        return authService.me();
    }
    
}

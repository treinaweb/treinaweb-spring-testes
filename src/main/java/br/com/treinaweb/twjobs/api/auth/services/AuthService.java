package br.com.treinaweb.twjobs.api.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.api.auth.dtos.LoginRequest;
import br.com.treinaweb.twjobs.api.auth.dtos.MeResponse;
import br.com.treinaweb.twjobs.api.auth.dtos.TokenResponse;
import br.com.treinaweb.twjobs.api.auth.mappers.AuthMapper;
import br.com.treinaweb.twjobs.core.repositories.CandidateRepository;
import br.com.treinaweb.twjobs.core.repositories.CompanyRepository;
import br.com.treinaweb.twjobs.core.services.auth.SecurityService;
import br.com.treinaweb.twjobs.core.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper authMapper;
    private final JwtService jwtService;
    private final SecurityService securityService;
    private final CompanyRepository companyRepository;
    private final CandidateRepository candidateRepository;
    private final AuthenticationManager authenticationManager;

    public TokenResponse login(LoginRequest loginRequest) {
        var authentication = new UsernamePasswordAuthenticationToken(
            loginRequest.getEmail(),
            loginRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);
        return TokenResponse.builder()
            .token(jwtService.generateToken(loginRequest.getEmail()))
            .build();
    }

    public MeResponse me() {
        var authException = new UsernameNotFoundException("User not found");

        var user = securityService.getAuthenticatedUser();

        if (user.getRole().equals("COMPANY")) {
            return companyRepository.findByEmail(user.getUsername())
                .map(authMapper::toMeCompanyResponse)
                .orElseThrow(() -> authException);
        }
        return candidateRepository.findByEmail(user.getUsername())
            .map(authMapper::toMeCandidateResponse)
            .orElseThrow(() -> authException);
    }
    
}

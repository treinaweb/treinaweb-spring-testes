package br.com.treinaweb.twjobs.core.services.jwt;

public interface JwtService {

    String generateToken(String sub);
    String getSubFromToken(String token);
    
}

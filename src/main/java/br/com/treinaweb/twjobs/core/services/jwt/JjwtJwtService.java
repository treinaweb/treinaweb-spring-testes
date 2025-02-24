package br.com.treinaweb.twjobs.core.services.jwt;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.config.JwtConfigProperties;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JjwtJwtService implements JwtService {

    private final JwtConfigProperties jwtConfigProperties;
    
    // Used for testing purposes
    private Clock clock;

    @Override
    public String generateToken(String sub) {
        var now = (clock == null) ? Instant.now() : Instant.now(clock);
        var expiration = now.plus(jwtConfigProperties.getExpiration());
        var key = Keys.hmacShaKeyFor(jwtConfigProperties.getSecret().getBytes());
        return Jwts.builder()
            .subject(sub)
            .issuedAt(Date.from(now))
            .expiration(Date.from(expiration))
            .signWith(key)
            .compact();
    }

    @Override
    public String getSubFromToken(String token) {
        var key = Keys.hmacShaKeyFor(jwtConfigProperties.getSecret().getBytes());
        try {
            return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
        } catch (JwtException e) {
            throw new JwtServiceException(e.getLocalizedMessage());
        }
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
    
}

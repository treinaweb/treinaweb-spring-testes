package br.com.treinaweb.twjobs.config;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "br.com.treinaweb.twjobs.jwt")
public class JwtConfigProperties {

    private String secret;
    private Duration expiration;
    
}

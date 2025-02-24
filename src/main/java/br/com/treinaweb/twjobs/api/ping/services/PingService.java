package br.com.treinaweb.twjobs.api.ping.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PingService {
    
    public Map<String, String> ping() {
        return Map.of("message", "pong");
    }

}

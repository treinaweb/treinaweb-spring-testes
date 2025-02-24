package br.com.treinaweb.twjobs.api.candidates.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.twjobs.api.candidates.dtos.CandidateRequest;
import br.com.treinaweb.twjobs.api.candidates.dtos.CandidateResponse;
import br.com.treinaweb.twjobs.api.candidates.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candidates")
public class CandidateRestController {

    private final CandidateService candidateService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CandidateResponse create(@Valid @RequestBody CandidateRequest candidateRequest) {
        return candidateService.create(candidateRequest);
    }

    @GetMapping("/{id}")
    public CandidateResponse findById(@PathVariable UUID id) {
        return candidateService.findById(id);
    }
    
}

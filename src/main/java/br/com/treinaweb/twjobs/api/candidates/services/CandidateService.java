package br.com.treinaweb.twjobs.api.candidates.services;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.api.candidates.dtos.CandidateRequest;
import br.com.treinaweb.twjobs.api.candidates.dtos.CandidateResponse;
import br.com.treinaweb.twjobs.api.candidates.mappers.CandidateMapper;
import br.com.treinaweb.twjobs.core.exceptions.candidate.CandidateEmailAlreadyInUseException;
import br.com.treinaweb.twjobs.core.exceptions.candidate.CandidateGithubAlreadyInUseException;
import br.com.treinaweb.twjobs.core.exceptions.candidate.CandidateLinkedinAlreadyInUseException;
import br.com.treinaweb.twjobs.core.exceptions.candidate.CandidateNotFoundException;
import br.com.treinaweb.twjobs.core.repositories.CandidateRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateMapper candidateMapper;
    private final PasswordEncoder passwordEncoder;
    private final CandidateRepository candidateRepository;

    public CandidateResponse create(CandidateRequest candidateRequest) {
        if (candidateRepository.existsByEmail(candidateRequest.getEmail())) {
            throw new CandidateEmailAlreadyInUseException();
        }
        if (candidateRepository.existsByGithub(candidateRequest.getGithub())) {
            throw new CandidateGithubAlreadyInUseException();
        }
        if (candidateRepository.existsByLinkedin(candidateRequest.getLinkedin())) {
            throw new CandidateLinkedinAlreadyInUseException();
        }

        var candidate = candidateMapper.toModel(candidateRequest);
        candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));
        var candidateSaved = candidateRepository.save(candidate);
        return candidateMapper.toResponse(candidateSaved);
    }

    public CandidateResponse findById(UUID id) {
        return candidateRepository.findById(id)
            .map(candidateMapper::toResponse)
            .orElseThrow(CandidateNotFoundException::new);
    }
    
}

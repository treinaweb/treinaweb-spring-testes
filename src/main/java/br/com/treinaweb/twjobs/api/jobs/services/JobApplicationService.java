package br.com.treinaweb.twjobs.api.jobs.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.api.jobs.dtos.JobApplicationResponse;
import br.com.treinaweb.twjobs.api.jobs.mappers.JobApplicationMapper;
import br.com.treinaweb.twjobs.core.exceptions.candidate.CandidateNotFoundException;
import br.com.treinaweb.twjobs.core.exceptions.job.JobNotFoundException;
import br.com.treinaweb.twjobs.core.repositories.CandidateRepository;
import br.com.treinaweb.twjobs.core.repositories.JobRepository;
import br.com.treinaweb.twjobs.core.services.auth.SecurityService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobRepository jobRepository;
    private final SecurityService securityService;
    private final CandidateRepository candidateRepository;
    private final JobApplicationMapper jobApplicationMapper;

    public void create(UUID id) {
        var job = jobRepository.findById(id).orElseThrow(JobNotFoundException::new);
        var candidateId = securityService.getAuthenticatedUser().getId();
        if (jobRepository.existsByIdAndCandidatesId(id, candidateId)) {
            return;
        }
        var candidate = candidateRepository.findById(candidateId).orElseThrow(CandidateNotFoundException::new);
        job.getCandidates().add(candidate);
        jobRepository.save(job);
    }

    public List<JobApplicationResponse> findAll(UUID id) {
        return jobRepository.findById(id)
            .orElseThrow(JobNotFoundException::new)
            .getCandidates()
            .stream()
            .map(jobApplicationMapper::toResponse)
            .toList();
    }
    
}

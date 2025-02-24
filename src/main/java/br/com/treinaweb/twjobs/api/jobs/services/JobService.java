package br.com.treinaweb.twjobs.api.jobs.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.api.jobs.dtos.JobRequest;
import br.com.treinaweb.twjobs.api.jobs.dtos.JobResponse;
import br.com.treinaweb.twjobs.api.jobs.mappers.JobMapper;
import br.com.treinaweb.twjobs.core.exceptions.job.JobNotFoundException;
import br.com.treinaweb.twjobs.core.models.Company;
import br.com.treinaweb.twjobs.core.repositories.JobRepository;
import br.com.treinaweb.twjobs.core.repositories.SkillRepository;
import br.com.treinaweb.twjobs.core.services.auth.SecurityService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobMapper jobMapper;
    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;
    private final SecurityService securityService;

    public List<JobResponse> findAll() {
        return jobRepository.findAll()
            .stream()
            .map(jobMapper::toResponse)
            .toList();
    }

    public JobResponse create(JobRequest jobRequest) {
        var job = jobMapper.toModel(jobRequest);
        var companyId = securityService.getAuthenticatedUser().getId();
        var company = Company.builder().id(companyId).build();
        job.setCompany(company);
        var skills = skillRepository.findAllByNameIn(jobRequest.getSkills());
        job.setSkills(skills);
        var createdJob = jobRepository.save(job);
        return jobMapper.toResponse(createdJob);
    }

    public JobResponse findById(UUID id) {
        return jobRepository.findById(id)
            .map(jobMapper::toResponse)
            .orElseThrow(JobNotFoundException::new);
    }
    
}

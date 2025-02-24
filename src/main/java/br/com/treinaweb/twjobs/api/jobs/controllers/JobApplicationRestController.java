package br.com.treinaweb.twjobs.api.jobs.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.twjobs.api.jobs.dtos.JobApplicationResponse;
import br.com.treinaweb.twjobs.api.jobs.services.JobApplicationService;
import br.com.treinaweb.twjobs.core.permissions.TWJobsPermissions;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs/{id}/applications")
public class JobApplicationRestController {

    private final JobApplicationService jobApplicationService;

    @PostMapping
    @TWJobsPermissions.IsCandidate
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void create(@PathVariable UUID id) {
        jobApplicationService.create(id);
    }

    @GetMapping
    @TWJobsPermissions.IsCompanyOwnerOfJob
    public List<JobApplicationResponse> findAll(@PathVariable UUID id) {
        return jobApplicationService.findAll(id);
    }
    
}

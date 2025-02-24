package br.com.treinaweb.twjobs.api.jobs.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.twjobs.api.jobs.dtos.JobRequest;
import br.com.treinaweb.twjobs.api.jobs.dtos.JobResponse;
import br.com.treinaweb.twjobs.api.jobs.services.JobService;
import br.com.treinaweb.twjobs.core.permissions.TWJobsPermissions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobRestController {

    private final JobService jobService;

    @GetMapping
    public List<JobResponse> findAll() {
        return jobService.findAll();
    }
    
    @PostMapping
    @TWJobsPermissions.IsCompany
    @ResponseStatus(code = HttpStatus.CREATED)
    public JobResponse create(@RequestBody @Valid JobRequest jobRequest) {
        return jobService.create(jobRequest);
    }
    
    @GetMapping("/{id}")
    public JobResponse findById(@PathVariable UUID id) {
        return jobService.findById(id);
    }

}

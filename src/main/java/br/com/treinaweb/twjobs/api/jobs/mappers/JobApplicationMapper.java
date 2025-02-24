package br.com.treinaweb.twjobs.api.jobs.mappers;

import br.com.treinaweb.twjobs.api.jobs.dtos.JobApplicationResponse;
import br.com.treinaweb.twjobs.core.models.Candidate;

public interface JobApplicationMapper {

    JobApplicationResponse toResponse(Candidate candidate);
    
}

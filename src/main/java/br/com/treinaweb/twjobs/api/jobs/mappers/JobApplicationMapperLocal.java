package br.com.treinaweb.twjobs.api.jobs.mappers;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.treinaweb.twjobs.api.jobs.dtos.JobApplicationResponse;
import br.com.treinaweb.twjobs.core.models.Candidate;

@Component
public class JobApplicationMapperLocal implements JobApplicationMapper {

    @Override
    public JobApplicationResponse toResponse(Candidate candidate) {
        if (Objects.isNull(candidate)) {
            throw new IllegalArgumentException("canidate cannot be null");
        }

        return JobApplicationResponse.builder()
            .id(candidate.getId())
            .name(candidate.getName())
            .description(candidate.getDescription())
            .email(candidate.getEmail())
            .github(candidate.getGithub())
            .linkedin(candidate.getLinkedin())
            .build();
    }
    
}

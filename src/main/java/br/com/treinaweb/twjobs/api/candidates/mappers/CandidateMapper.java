package br.com.treinaweb.twjobs.api.candidates.mappers;

import br.com.treinaweb.twjobs.api.candidates.dtos.CandidateRequest;
import br.com.treinaweb.twjobs.api.candidates.dtos.CandidateResponse;
import br.com.treinaweb.twjobs.core.models.Candidate;

public interface CandidateMapper {

    CandidateResponse toResponse(Candidate candidate);
    Candidate toModel(CandidateRequest candidateRequest);
    
}

package br.com.treinaweb.twjobs.api.auth.mappers;

import br.com.treinaweb.twjobs.api.auth.dtos.MeCandidateResponse;
import br.com.treinaweb.twjobs.api.auth.dtos.MeCompanyResponse;
import br.com.treinaweb.twjobs.core.models.Candidate;
import br.com.treinaweb.twjobs.core.models.Company;

public interface AuthMapper {

    MeCompanyResponse toMeCompanyResponse(Company company);
    MeCandidateResponse toMeCandidateResponse(Candidate candidate);
    
}

package br.com.treinaweb.twjobs.api.companies.mappers;

import br.com.treinaweb.twjobs.api.companies.dtos.CompanyRequest;
import br.com.treinaweb.twjobs.api.companies.dtos.CompanyResponse;
import br.com.treinaweb.twjobs.core.models.Company;

public interface CompanyMapper {

    CompanyResponse toResponse(Company company);
    Company toModel(CompanyRequest companyRequest);
    
}

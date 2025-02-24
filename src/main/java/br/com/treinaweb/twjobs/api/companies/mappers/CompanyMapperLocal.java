package br.com.treinaweb.twjobs.api.companies.mappers;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.treinaweb.twjobs.api.companies.dtos.CompanyRequest;
import br.com.treinaweb.twjobs.api.companies.dtos.CompanyResponse;
import br.com.treinaweb.twjobs.core.models.Company;

@Component
public class CompanyMapperLocal implements CompanyMapper {

    @Override
    public CompanyResponse toResponse(Company company) {
        if (Objects.isNull(company)) {
            throw new IllegalArgumentException("company cannot be null");
        }

        return CompanyResponse.builder()
            .id(company.getId())
            .name(company.getName())
            .website(company.getWebsite())
            .description(company.getDescription())
            .email(company.getEmail())
            .build();
    }

    @Override
    public Company toModel(CompanyRequest companyRequest) {
        if (Objects.isNull(companyRequest)) {
            throw new IllegalArgumentException("companyRequest cannot be null");
        }

        return Company.builder()
            .name(companyRequest.getName())
            .website(companyRequest.getWebsite())
            .description(companyRequest.getDescription())
            .email(companyRequest.getEmail())
            .password(companyRequest.getPassword())
            .build();
    }
    
}

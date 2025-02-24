package br.com.treinaweb.twjobs.api.companies.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {

    private UUID id;

    private String name;

    private String website;

    private String description;
    
    private String email;
    
}

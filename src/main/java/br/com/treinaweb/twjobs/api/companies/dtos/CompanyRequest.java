package br.com.treinaweb.twjobs.api.companies.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank
    @URL(protocol = "https")
    @Size(min = 3, max = 255)
    private String website;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    
    @Email
    @NotBlank
    @Size(min = 3, max = 255)
    private String email;

    @NotBlank
    @Size(min = 6, max = 255)
    private String password;
    
}

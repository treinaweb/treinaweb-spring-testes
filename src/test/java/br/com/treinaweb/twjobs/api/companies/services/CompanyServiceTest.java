package br.com.treinaweb.twjobs.api.companies.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.treinaweb.twjobs.api.companies.mappers.CompanyMapper;
import br.com.treinaweb.twjobs.core.exceptions.company.CompanyEmailAlredyInUseException;
import br.com.treinaweb.twjobs.core.exceptions.company.CompanyNameAlredyInUseException;
import br.com.treinaweb.twjobs.core.exceptions.company.CompanyNotFoundException;
import br.com.treinaweb.twjobs.core.repositories.CompanyRepository;
import br.com.treinaweb.twjobs.testutils.factories.CompanyFactory;
import br.com.treinaweb.twjobs.testutils.factories.CompanyRequestFactory;
import br.com.treinaweb.twjobs.testutils.factories.CompanyResponseFactory;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    private CompanyMapper companyMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Test
    @Tags({@Tag("service"), @Tag("fast")})
    @DisplayName("findById() should return a CompanyResponse when Company id is found")
    void findById_shouldReturnCompanyResponse_whenCompanyIdIsFound() {
        // Arrange
        var company = CompanyFactory.createTreinaweb();
        var expectedCompanyResponse = CompanyResponseFactory.createTreinaweb();

        when(companyRepository.findById(company.getId())).thenReturn(Optional.of(company));
        when(companyMapper.toResponse(company)).thenReturn(expectedCompanyResponse);

        // Act
        var actual = companyService.findById(company.getId());

        // Assert
        assertNotNull(actual);
        assertEquals(expectedCompanyResponse.getId(), actual.getId());
        assertEquals(expectedCompanyResponse.getName(), actual.getName());
        assertEquals(expectedCompanyResponse.getDescription(), actual.getDescription());
        assertEquals(expectedCompanyResponse.getWebsite(), actual.getWebsite());
        assertEquals(expectedCompanyResponse.getEmail(), actual.getEmail());
    }
    
    @Test
    @Tags({@Tag("service"), @Tag("fast")})
    @DisplayName("findById() should return thrown CompanyNotFoundException when Comany Id not found")
    void findById_shouldThrowException_whenIdNotFound() {
        // Arrenge
        var id = UUID.randomUUID();

        when(companyRepository.findById(id)).thenReturn(Optional.empty());

        // Act / Assert
        assertThrows(CompanyNotFoundException.class, () -> companyService.findById(id));
    }
    
    @Test
    @Tags({@Tag("service"), @Tag("fast")})
    @DisplayName("create() should return thrown CompanyEmailAlredyInUseException when Comany email already registred")
    void create_shouldThrowExpcetion_whenDuplicatedEmail() {
        // Arrenge
        var companyRequest = CompanyRequestFactory.createTreinaweb();

        when(companyRepository.existsByEmail(companyRequest.getEmail())).thenReturn(true);

        // Act / Assert
        assertThrows(CompanyEmailAlredyInUseException.class, () -> companyService.create(companyRequest));
    }
    
    @Test
    @Tags({@Tag("service"), @Tag("fast")})
    @DisplayName("create() should return thrown CompanyNameAlredyInUseException when Comany name already registred")
    void create_shouldThrowExpcetion_whenDuplicatedName() {
        // Arrenge
        var companyRequest = CompanyRequestFactory.createTreinaweb();

        when(companyRepository.existsByEmail(companyRequest.getEmail())).thenReturn(false);
        when(companyRepository.existsByName(companyRequest.getName())).thenReturn(true);

        // Act / Assert
        assertThrows(CompanyNameAlredyInUseException.class, () -> companyService.create(companyRequest));
    }
    
    @Test
    @Tags({@Tag("service"), @Tag("fast")})
    @DisplayName("create() should return a CompanyResponse when Company is provided")
    void create_shouldReturnCompanyResponse_whenComanyProvided() {
        // Arrenge
        var companyRequest = CompanyRequestFactory.createTreinaweb();
        var expectedCompanyResponse = CompanyResponseFactory.createTreinaweb();
        var company = CompanyFactory.createTreinaweb();

        when(companyRepository.existsByEmail(companyRequest.getEmail())).thenReturn(false);
        when(companyRepository.existsByName(companyRequest.getName())).thenReturn(false);
        when(companyMapper.toModel(companyRequest)).thenReturn(company);
        when(passwordEncoder.encode(company.getPassword())).thenReturn("hashedpassword");
        when(companyRepository.save(company)).thenReturn(company);
        when(companyMapper.toResponse(company)).thenReturn(expectedCompanyResponse);

        // Act
        var actual = companyService.create(companyRequest);

        // Assert
        assertNotNull(actual);
        assertEquals(expectedCompanyResponse.getId(), actual.getId());
        assertEquals(expectedCompanyResponse.getName(), actual.getName());
        assertEquals(expectedCompanyResponse.getDescription(), actual.getDescription());
        assertEquals(expectedCompanyResponse.getWebsite(), actual.getWebsite());
        assertEquals(expectedCompanyResponse.getEmail(), actual.getEmail());
    }

}

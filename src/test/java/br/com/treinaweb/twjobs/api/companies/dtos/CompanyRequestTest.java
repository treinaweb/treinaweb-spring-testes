package br.com.treinaweb.twjobs.api.companies.dtos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import br.com.treinaweb.twjobs.testutils.factories.CompanyRequestFactory;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class CompanyRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        var factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @Tags({@Tag("validate"), @Tag("fast")})
    @DisplayName("when validate CompanyRequest with valid data then no violations should be returned")
    void whenValidateValidCompanyRequest_thenNoErrors() {
        // Arrange
        var companyRequest = CompanyRequestFactory.createTreinaweb();

        // Act
        var actual = validator.validate(companyRequest);

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    @Tags({@Tag("validate"), @Tag("fast")})
    @DisplayName("when validate CompanyRequest with invalid name violations should be returned")
    void whenValidateInValidCompanyRequestName_thenErrors() {
        // Arrange
        var companyRequest = CompanyRequestFactory.createTreinaweb();
        companyRequest.setName(null);

        // Act
        var actual = validator.validate(companyRequest);

        // Assert
        assertFalse(actual.isEmpty());
    }

}

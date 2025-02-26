package br.com.treinaweb.twjobs.api.companies.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompanyRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tags({@Tag("controller"), @Tag("slow")})
    @DisplayName("when POST /api/companies with valid body then return 201")
    void whePostApiCompaniesWithValidBodyThenReturns201() throws Exception {
        var body = """
        {
            "name": "TreinaWeb",
            "website": "https://www.treinaweb.com.br",
            "description": "A TreinaWeb é uma empresa especializada em cursos de tecnologia.",
            "email": "contato@treinaweb.com.br",
            "password": "senha@123"
        }
        """;
        var requestBuilder = post("/api/companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body);
        mockMvc.perform(requestBuilder)
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.name").value("TreinaWeb"))
            .andExpect(jsonPath("$.website").value("https://www.treinaweb.com.br"))
            .andExpect(jsonPath("$.description").value("A TreinaWeb é uma empresa especializada em cursos de tecnologia."))
            .andExpect(jsonPath("$.email").value("contato@treinaweb.com.br"));
    }

}

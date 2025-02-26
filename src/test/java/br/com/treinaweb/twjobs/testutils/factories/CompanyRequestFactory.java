package br.com.treinaweb.twjobs.testutils.factories;

import br.com.treinaweb.twjobs.api.companies.dtos.CompanyRequest;

public class CompanyRequestFactory {
    
    public static CompanyRequest createTreinaweb() {
        return CompanyRequest.builder()
            .name("TreinaWeb")
            .website("https://www.treinaweb.com.br")
            .description("Empresa especializada em cursos de programação")
            .email("contato@treinaweb.com.br")
            .password("senha@123")
            .build();
    }

    public static CompanyRequest createAVMakers() {
        return CompanyRequest.builder()
            .name("AVMakers")
            .website("https://www.avmakers.com.br")
            .description("Empresa especializada em cursos de áudio visual")
            .email("contato@avmakers.com.br")
            .password("senha@123")
            .build();
    }

}

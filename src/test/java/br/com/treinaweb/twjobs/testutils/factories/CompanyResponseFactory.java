package br.com.treinaweb.twjobs.testutils.factories;

import java.util.UUID;

import br.com.treinaweb.twjobs.api.companies.dtos.CompanyResponse;

public class CompanyResponseFactory {

    public static CompanyResponse createTreinaweb() {
        return CompanyResponse.builder()
            .id(UUID.fromString("2ab0f478-26af-4cf3-a2ec-7be5102417f8"))
            .name("TreinaWeb")
            .website("https://www.treinaweb.com.br")
            .description("Empresa especializada em cursos de programação")
            .email("contato@treinaweb.com.br")
            .build();
    }

    public static CompanyResponse createAVMakers() {
        return CompanyResponse.builder()
            .id(UUID.fromString("928ff78f-058a-43d0-92da-a53996c19200"))
            .name("AVMakers")
            .website("https://www.avmakers.com.br")
            .description("Empresa especializada em cursos de áudio visual")
            .email("contato@avmakers.com.br")
            .build();
    }
    
}

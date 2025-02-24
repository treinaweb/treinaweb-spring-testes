package br.com.treinaweb.twjobs.core.exceptions.company;

import br.com.treinaweb.twjobs.core.exceptions.ModelNotFoundException;

public class CompanyNotFoundException extends ModelNotFoundException {

    public CompanyNotFoundException() {
        super("Company not found");
    }
    
}

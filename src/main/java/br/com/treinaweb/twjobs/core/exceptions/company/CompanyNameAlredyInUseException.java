package br.com.treinaweb.twjobs.core.exceptions.company;

import br.com.treinaweb.twjobs.core.exceptions.ModelAlreadyExistsException;

public class CompanyNameAlredyInUseException extends ModelAlreadyExistsException {

    public CompanyNameAlredyInUseException() {
        super("Company name already in use");
    }
    
}

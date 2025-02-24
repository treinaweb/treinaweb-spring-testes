package br.com.treinaweb.twjobs.core.exceptions.company;

import br.com.treinaweb.twjobs.core.exceptions.ModelAlreadyExistsException;

public class CompanyEmailAlredyInUseException extends ModelAlreadyExistsException {

    public CompanyEmailAlredyInUseException() {
        super("Company email already in use");
    }
    
}

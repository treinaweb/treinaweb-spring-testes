package br.com.treinaweb.twjobs.core.exceptions.candidate;

import br.com.treinaweb.twjobs.core.exceptions.ModelAlreadyExistsException;

public class CandidateEmailAlreadyInUseException extends ModelAlreadyExistsException {

    public CandidateEmailAlreadyInUseException() {
        super("Candidate email already in use");
    }
    
}

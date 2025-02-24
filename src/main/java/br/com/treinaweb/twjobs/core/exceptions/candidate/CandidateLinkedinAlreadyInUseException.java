package br.com.treinaweb.twjobs.core.exceptions.candidate;

import br.com.treinaweb.twjobs.core.exceptions.ModelAlreadyExistsException;

public class CandidateLinkedinAlreadyInUseException extends ModelAlreadyExistsException {

    public CandidateLinkedinAlreadyInUseException() {
        super("Candidate linkedin already in use");
    }
    
}

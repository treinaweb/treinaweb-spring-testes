package br.com.treinaweb.twjobs.core.exceptions.candidate;

import br.com.treinaweb.twjobs.core.exceptions.ModelNotFoundException;

public class CandidateNotFoundException extends ModelNotFoundException {

    public CandidateNotFoundException() {
        super("Candidate not found");
    }
    
}

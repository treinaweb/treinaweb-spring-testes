package br.com.treinaweb.twjobs.core.exceptions.candidate;

import br.com.treinaweb.twjobs.core.exceptions.ModelAlreadyExistsException;

public class CandidateGithubAlreadyInUseException extends ModelAlreadyExistsException {

    public CandidateGithubAlreadyInUseException() {
        super("Candidate github already in use");
    }
    
}

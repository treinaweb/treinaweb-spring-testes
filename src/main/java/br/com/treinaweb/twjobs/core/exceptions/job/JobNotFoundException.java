package br.com.treinaweb.twjobs.core.exceptions.job;

import br.com.treinaweb.twjobs.core.exceptions.ModelNotFoundException;

public class JobNotFoundException extends ModelNotFoundException {

    public JobNotFoundException() {
        super("Job not found");
    }
    
}

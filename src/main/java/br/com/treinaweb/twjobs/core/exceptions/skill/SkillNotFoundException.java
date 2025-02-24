package br.com.treinaweb.twjobs.core.exceptions.skill;

import br.com.treinaweb.twjobs.core.exceptions.ModelNotFoundException;

public class SkillNotFoundException extends ModelNotFoundException {

    public SkillNotFoundException() {
        super("Skill not found");
    }
    
}

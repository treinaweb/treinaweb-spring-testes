package br.com.treinaweb.twjobs.api.skills.mappers;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;
import br.com.treinaweb.twjobs.core.models.Skill;

public interface SkillMapper {

    SkillResponse toResponse(Skill skill);
    
}

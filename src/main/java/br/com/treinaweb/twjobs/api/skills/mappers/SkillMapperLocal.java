package br.com.treinaweb.twjobs.api.skills.mappers;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;
import br.com.treinaweb.twjobs.core.models.Skill;

@Component
public class SkillMapperLocal implements SkillMapper {

    @Override
    public SkillResponse toResponse(Skill skill) {
        if (Objects.isNull(skill)) {
            throw new IllegalArgumentException("skill cannot be null");
        }

        return new SkillResponse(skill.getId(), skill.getName());
    }
    
}

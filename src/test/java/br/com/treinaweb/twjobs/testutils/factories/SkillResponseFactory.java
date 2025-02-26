package br.com.treinaweb.twjobs.testutils.factories;

import java.util.List;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;

public class SkillResponseFactory {

    public static SkillResponse createJava() {
        return new SkillResponse(1L, "Java");
    }

    public static SkillResponse createSpring() {
        return new SkillResponse(2L, "Spring");
    }

    public static List<SkillResponse> createSkills() {
        return List.of(createJava(), createSpring());
    }
    
}

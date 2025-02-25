package br.com.treinaweb.twjobs.api.skills.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;
import br.com.treinaweb.twjobs.core.models.Skill;

public class SkillMapperLocalTest {

    @Test
    @Tags({@Tag("mapper"), @Tag("fast")})
    @DisplayName("toResponse() should convert a Skill into a SkillResponse")
    void toResponse_shouldConvertSkillToSkillResponse_whenSkillIsProvided() {
        // Arrange
        var skill = Skill.builder()
            .id(1L)
            .name("Java")
            .build();
        var expectedSkillResponse = SkillResponse.builder()
            .id(1L)
            .name("Java")
            .build();

        var skillMapper = new SkillMapperLocal();

        // Act
        var actual = skillMapper.toResponse(skill);

        // Assert
        assertNotNull(actual);
        assertEquals(expectedSkillResponse.getId(), actual.getId());
        assertEquals(expectedSkillResponse.getName(), actual.getName());
    }

    @Test
    @Tags({@Tag("mapper"), @Tag("fast")})
    @DisplayName("toResponse() should convert throw IllegalArgumentException when skill is null")
    void toResponse_shouldThrowException_whenSkillNull() {
        // Arrange
        var skillMapper = new SkillMapperLocal();

        // Act / Assertion
        var exception = assertThrows(IllegalArgumentException.class, () -> skillMapper.toResponse(null));
        assertEquals("skill cannot be null", exception.getMessage());
    }

}

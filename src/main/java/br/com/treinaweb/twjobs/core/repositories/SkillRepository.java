package br.com.treinaweb.twjobs.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twjobs.core.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findAllByNameIn(Iterable<String> names);
    
}

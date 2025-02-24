package br.com.treinaweb.twjobs.api.skills.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;
import br.com.treinaweb.twjobs.api.skills.mappers.SkillMapper;
import br.com.treinaweb.twjobs.core.exceptions.skill.SkillNotFoundException;
import br.com.treinaweb.twjobs.core.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;

    public List<SkillResponse> findAll(Sort sort) {
        return skillRepository.findAll(sort)
            .stream()
            .map(skillMapper::toResponse)
            .toList();
    }

    public SkillResponse findById(Long id) {
        return skillRepository.findById(id)
            .map(skillMapper::toResponse)
            .orElseThrow(SkillNotFoundException::new);
    }
    
}

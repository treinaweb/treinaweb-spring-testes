package br.com.treinaweb.twjobs.core.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twjobs.core.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {

    Boolean existsByEmail(String email);
    Boolean existsByGithub(String github);
    Boolean existsByLinkedin(String linkedin);
    Optional<Candidate> findByEmail(String email);
    
}

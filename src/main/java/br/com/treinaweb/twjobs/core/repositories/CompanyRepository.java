package br.com.treinaweb.twjobs.core.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twjobs.core.models.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Boolean existsByName(String name);
    Boolean existsByNameAndIdNot(String name, UUID id);
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndIdNot(String email, UUID id);
    Optional<Company> findByEmail(String email);
    
}

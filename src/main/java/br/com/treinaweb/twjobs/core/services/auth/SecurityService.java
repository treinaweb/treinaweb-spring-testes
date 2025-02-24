package br.com.treinaweb.twjobs.core.services.auth;

import java.util.UUID;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twjobs.core.repositories.JobRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final JobRepository jobRepository;

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean isAuthenticated() {
        var authentication = getAuthentication();
        return authentication != null
            && !(authentication instanceof AnonymousAuthenticationToken)
            && authentication.isAuthenticated();
    }

    public AuthenticatedUser getAuthenticatedUser() {
        if (!isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }
        
        var authentication = getAuthentication();
        if (!(authentication.getPrincipal() instanceof AuthenticatedUser)) {
            throw new IllegalStateException("Principal is not an instance of AuthenticatedUser");
        }

        return (AuthenticatedUser) authentication.getPrincipal();
    }

    public boolean isCompanyOwnerOfJob(UUID jobId) {
        return isAuthenticated() &&
            jobRepository.existsByIdAndCompanyId(jobId, getAuthenticatedUser().getId());
    }
    
}

package com.codegym.demo.config;

import com.example.demologin.entity.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        if(SecurityContextHolder.getContext().getAuthentication() == null) {
            return Optional.empty();
        }
        return Optional.of(
                ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
}

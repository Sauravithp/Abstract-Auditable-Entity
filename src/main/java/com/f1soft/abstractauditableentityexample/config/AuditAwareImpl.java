package com.f1soft.abstractauditableentityexample.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor() {
         /*
          if you are using spring security, you can get the currently logged username with following code segment.
          SecurityContextHolder.getContext().getAuthentication().getName()
         */
        return Optional.ofNullable("sauravi");
    }
}

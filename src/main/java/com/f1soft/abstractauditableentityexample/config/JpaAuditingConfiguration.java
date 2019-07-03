package com.f1soft.abstractauditableentityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Profile("dev")
public class JpaAuditingConfiguration {
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditAwareImpl();
    }
}

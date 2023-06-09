package com.jm.portfolio.global.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.jm.portfolio"})
@EnableJpaRepositories(basePackages = {"com.jm.portfolio"})
@EnableJpaAuditing
public class JpaConfig {
}

package com.businesstier.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        repositoryBaseClass = ExtendedClientRepoImpl.class)
public class ConfigJPA {
    // additional JPA Configuration
}

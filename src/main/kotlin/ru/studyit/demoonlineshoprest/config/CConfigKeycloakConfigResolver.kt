package ru.studyit.demoonlineshoprest.config

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CConfigKeycloakConfigResolver {
    @Bean
    fun keycloakConfigResolver()            : KeycloakSpringBootConfigResolver? {
        return KeycloakSpringBootConfigResolver()
    }
}
package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 1. Anotación para configurar Spring Security
public class SecurityConfig {
  // 2. Declarar rutas publicas
  private final String[] PUBLIC_RESOURCES = { "/services/public/get/**", "/auth/**" };

  // @Bean Annotation: Indica a Spring que el objeto retornado por el
  // metodo debe ser registrado como un bean en el contexto de la app
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable()) // Desabilitar csrf para apps monoliticas(porque estamos con api)
        .authorizeHttpRequests(authRequest -> authRequest
            .requestMatchers(PUBLIC_RESOURCES).permitAll()
            .anyRequest().authenticated())
        .build();
  }
}

package com.IoTeam.ThirstySeedAPI.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configuración básica de CORS sin seguridad habilitada
        http.cors(configurer -> configurer.configurationSource(request -> {
            var cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("*"));
            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        }));

        http.csrf(csrfConfigurer -> csrfConfigurer.disable())
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .anyRequest().permitAll());

        return http.build();
    }
}

package com.IoTeam.ThirstySeedAPI.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Permitir acceso sin autenticación a Swagger y otros recursos públicos
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        // Proteger el resto de endpoints
                        .anyRequest().authenticated()
                )
                .httpBasic(customizer -> customizer.disable()) // Deshabilita la autenticación HTTP básica
                .formLogin(customizer -> customizer.disable()) // Deshabilita la autenticación basada en formularios
                .csrf(csrf -> csrf.disable()); // Deshabilita la protección CSRF

        return http.build();
    }
}

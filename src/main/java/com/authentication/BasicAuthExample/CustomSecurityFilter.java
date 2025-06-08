package com.authentication.BasicAuthExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
// This annotation indicates that this class contains Spring Security configuration
@EnableWebSecurity
// This annotation enables method-level security, allowing the use of annotations like @PreAuthorize
@EnableMethodSecurity
public class CustomSecurityFilter {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated());
        http.sessionManagement(
                session -> session.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)
        );
        //http.formLogin(withDefaults()); // Uncomment this line to enable form-based login
        http.headers(headers ->
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));// As frame for h2 console were not coming, we did this.
        http.csrf(csrf -> csrf.disable()); // Disable CSRF protection for H2 console
        http.httpBasic(withDefaults());
        return http.build();
    }
}

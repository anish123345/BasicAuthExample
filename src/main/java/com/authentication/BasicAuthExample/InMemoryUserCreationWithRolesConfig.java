package com.authentication.BasicAuthExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUserCreationWithRolesConfig {

    //@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("user1")
                .password("{noop}password1") // {noop} indicates no password encoder is used
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withUsername("admin")
                .password("{noop}password2") // {noop} indicates no password encoder is used
                .roles("ADMIN")
                .build();
        //InMemoryUserDetailsService implements the interface UserDetailsService
        return new InMemoryUserDetailsManager(user1, user2);
    }
}

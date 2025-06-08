package com.authentication.BasicAuthExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserCreationStoredInH2Database {

    @Autowired
    DataSource dataSource;

    @Bean
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
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user1);
        jdbcUserDetailsManager.createUser(user2);
        //JdbcUserDetailsManager implements the interface UserDetailsService
        return jdbcUserDetailsManager;
    }
}

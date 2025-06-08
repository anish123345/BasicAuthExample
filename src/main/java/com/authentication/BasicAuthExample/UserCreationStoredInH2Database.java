package com.authentication.BasicAuthExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserCreationStoredInH2Database {

    @Autowired
    DataSource dataSource;

    /**
     * Configures and returns a UserDetailsService bean.
     *
     * This method creates two users with encoded passwords and assigns them roles.
     * The users are stored in an H2 database using JdbcUserDetailsManager, which implements
     * the UserDetailsService interface. This allows Spring Security to retrieve user details
     * for authentication and authorization purposes.
     *
     * @return UserDetailsService - an instance of JdbcUserDetailsManager configured with the DataSource
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("user1")
                .password(passwordEncoder().encode("password1"))// {noop} not used now. We are encoding and saving to DB
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withUsername("admin")
                .password(passwordEncoder().encode("password2")) // {noop} not used now. We are encoding and saving to DB
                .roles("ADMIN")
                .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user1);
        jdbcUserDetailsManager.createUser(user2);
        //JdbcUserDetailsManager implements the interface UserDetailsService
        return jdbcUserDetailsManager;
    }

    /**
     * Creates and returns a PasswordEncoder bean.
     *
     * This method provides an instance of BCryptPasswordEncoder, which is used to encode passwords
     * securely using the BCrypt hashing algorithm. The encoded passwords can then be stored in the database.
     *
     * @return PasswordEncoder - an instance of BCryptPasswordEncoder
     */
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

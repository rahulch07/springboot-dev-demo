package com.example.cruddemo.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}pass").roles("EMPLOYEE").build();
        UserDetails marry = User.builder().username("marry").password("{noop}pass").roles("EMPLOYEE", "MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}pass").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, marry, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAllRoles("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAllRoles("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAllRoles("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAllRoles("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasAllRoles("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAllRoles("ADMIN")
                );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

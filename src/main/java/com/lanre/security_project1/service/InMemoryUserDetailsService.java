package com.lanre.security_project1.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> appUsers;
    public InMemoryUserDetailsService(List<UserDetails> appUsers) {
       this.appUsers = appUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUsers.stream()
                .filter(
                        u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );
    }
}

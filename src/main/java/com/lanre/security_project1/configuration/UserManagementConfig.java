package com.lanre.security_project1.configuration;


import com.lanre.security_project1.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserManagementConfig {

//    @Bean
//    UserDetailsService userDetailsService() {
//        var user = User.withUsername("john")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        var user2 = User.withUsername("lanre")
//                .password("54321")
//                .authorities("read", "write")
//                .build();
//        return new InMemoryUserDetailsManager(user, user2);
//    }
@Bean
public UserDetailsService userDetailsService() {
    List<SimpleGrantedAuthority> authorities =
            List.of(new SimpleGrantedAuthority("read"));
    UserDetails u = new User("john", "12345",authorities);
    List<UserDetails> users = List.of(u);
    return new InMemoryUserDetailsService(users);
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}

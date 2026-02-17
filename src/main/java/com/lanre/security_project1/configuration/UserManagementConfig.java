package com.lanre.security_project1.configuration;


import com.lanre.security_project1.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
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
//@Bean
//public UserDetailsService userDetailsService() {
//    List<SimpleGrantedAuthority> authorities =
//            List.of(new SimpleGrantedAuthority("read"));
//    UserDetails u = new User("john", "12345",authorities);
//    List<UserDetails> users = List.of(u);
//    return new InMemoryUserDetailsService(users);

//using datasource
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
       // return new JdbcUserDetailsManager(dataSource);
        String usersByUsernameQuery =
                "select username, password, enabled from users where username = ?";
        String authsByUserQuery =
                "select username, authority from spring.authorities where username = ?";
        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        return userDetailsManager;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }


    @Bean
   public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
   }
}


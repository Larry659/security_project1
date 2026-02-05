package com.lanre.security_project1.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Autowired
    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
    @Bean
    UserDetailsService userDetailsService() {
        var user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        var user2 = User.withUsername("lanre")
                .password("54321")
                .authorities("read", "write")
                .build();
        return new InMemoryUserDetailsManager(user, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
//To customize the handling of authentication and authorization, we’ll need to define a
//bean of type SecurityFilterChain
    @Bean
    SecurityFilterChain configure(HttpSecurity http)
            throws Exception {
       http.httpBasic(Customizer.withDefaults()); //App uses HTTP Basic authentication.
        http.authenticationProvider(authenticationProvider);
//        http.authorizeHttpRequests(
//                c -> c.anyRequest().authenticated() //All the requests require  authentication i.e must be checked.
        http.authorizeHttpRequests(
                c -> c.anyRequest().permitAll() //None of the requests need  to be authenticated
        );
        return http.build();
    }

}

package com.lanre.security_project1.configuration;


import com.lanre.security_project1.filters.AuthenticationLoggingFilter;
import com.lanre.security_project1.filters.RequestValidationFilter;
import com.lanre.security_project1.filters.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebAuthorizationConfig {



    private final StaticKeyAuthenticationFilter filter;

    public WebAuthorizationConfig(StaticKeyAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http)
            throws Exception {



//        http.addFilterBefore(
//                new RequestValidationFilter(), BasicAuthenticationFilter.class)
//
//                .addFilterAfter(
//                        new AuthenticationLoggingFilter(),//adds this filter after BasicAuthentication
//                        BasicAuthenticationFilter.class)
        http.addFilterAt(filter,BasicAuthenticationFilter.class)
       // http.httpBasic(Customizer.withDefaults()); //App uses HTTP Basic authentication.
        //http.authenticationProvider(customAuthenticationProvider);
//        http.authorizeHttpRequests(
//                c -> c.anyRequest().authenticated() //All the requests require  authentication i.e must be checked.
       .authorizeHttpRequests(
                c -> c.anyRequest().permitAll() //None of the requests need  to be authenticated
        );
        return http.build();
    }
}

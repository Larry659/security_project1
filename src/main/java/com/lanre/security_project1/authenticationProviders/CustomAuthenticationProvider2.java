//package com.lanre.security_project1.authenticationProviders;
//
//
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class CustomAuthenticationProvider2 implements AuthenticationProvider {
//
//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    public CustomAuthenticationProvider2(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) {
//        String username = authentication.getName();//supplied username by the user
//        String password = authentication.getCredentials().toString(); //supplied password by the user
//        UserDetails u = userDetailsService.loadUserByUsername(username);//fetch user details by username
//
//        if (passwordEncoder.matches(password, u.getPassword())) {//compare supplied credentials with saved credentials
//            return new UsernamePasswordAuthenticationToken(
//                    username,
//                    password,
//                    u.getAuthorities());
//        } else {
//
//            throw new BadCredentialsException
//            ("Something went wrong!");
//        }
//    }
//
//
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//        return authenticationType
//                .equals(UsernamePasswordAuthenticationToken.class);
//    }
//}

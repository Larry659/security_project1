//package com.lanre.security_project1.configuration;
//
//
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Override
//    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();//The getName()method is inherited by Authentication from the Principal interface.
//        String password = String.valueOf(
//                authentication.getCredentials());
//        if ("john".equals(username) && "12345".equals(password)) {//This condition call UserDetails and PassWordEncoder to test username and password.
//            return new UsernamePasswordAuthenticationToken(
//                    username,
//                    password,
//                    Arrays.asList());
//        } else {
//            throw new AuthenticationCredentialsNotFoundException("Error!");
//        }
//
//
//    }
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//        return UsernamePasswordAuthenticationToken
//                .class
//                .isAssignableFrom(authenticationType);
//    }
//}

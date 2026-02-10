package com.lanre.security_project1;

import com.lanre.security_project1.entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityAppUser implements UserDetails {
    private final AppUser appUseruser;

    public SecurityAppUser(AppUser appUseruser) {
        this.appUseruser = appUseruser;
    }

    @Override
    public final String getUsername() {
        return appUseruser.getUsername();
    }
    @Override
    public String getPassword() {
        return appUseruser.getPassword();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> appUseruser.getAuthority());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package org.studies.springsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.studies.springsecurity.domain.User;

public class SecurityUser extends User implements UserDetails {

    public SecurityUser() {}
    public SecurityUser(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setAuthorities(user.getAuthorities());
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

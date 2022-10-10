package org.studies.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.studies.springsecurity.domain.User;
import org.studies.springsecurity.repository.UserRepository;
import org.studies.springsecurity.security.SecurityUser;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Incorrect username or password");
        }

        return new SecurityUser(user);
    }
}

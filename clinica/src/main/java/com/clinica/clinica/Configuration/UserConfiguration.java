package com.clinica.clinica.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserConfiguration implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("joaovictor".equals(username)) {
            return org.springframework.security.core.userdetails.User.withUsername("joaovictor")
                    .password("{noop}32770780joao")
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }

}
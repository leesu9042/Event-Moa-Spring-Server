package com.example.eventmoa.global.security.auth;

import com.example.eventmoa.domain.user.facade.UserFacade;
import com.example.eventmoa.domain.user.persistence.User;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userFacade.getUserById(id);
        return new AuthDetails(user);
    }
}

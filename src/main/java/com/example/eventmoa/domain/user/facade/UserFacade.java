package com.example.eventmoa.domain.user.facade;

import com.example.eventmoa.domain.user.exception.UserNotFoundException;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String id =
                SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserById(id);
    }

    public User getUserById(String id) {
        return userRepository.findById((long) Integer.parseInt(id)).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}

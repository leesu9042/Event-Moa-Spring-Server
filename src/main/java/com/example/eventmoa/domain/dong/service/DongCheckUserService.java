package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.dong.exception.DongNotFoundException;
import com.example.eventmoa.domain.dong.persistence.Dong;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.user.facade.UserFacade;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DongCheckUserService {
    private final UserFacade userFacade;
    private final DongRepository dongRepository;

    public boolean check(Long id) {
        User user = userFacade.getCurrentUser();
        Dong dong = dongRepository.findById(id).orElseThrow(() -> DongNotFoundException.EXCEPTION);
        return (user.getRole().equals(Role.DONG) || user.getRole().equals(Role.MASTER) || dong.getUser().equals(user) );
    }
}

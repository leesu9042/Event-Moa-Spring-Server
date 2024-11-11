package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.dong.exception.DongNotFoundException;
import com.example.eventmoa.domain.dong.persistence.Dong;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.user.exception.UnauthorizedUserException;
import com.example.eventmoa.domain.user.facade.UserFacade;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DongDeleteService {
    private final DongRepository dongRepository;
    private final UserFacade userFacade;

    public void delete(Long id) {
        Dong dong = dongRepository.findById(id).orElseThrow(DongNotFoundException::new);
        User user = userFacade.getCurrentUser();

        if(!user.getId().equals(dong.getUser().getId()) && !user.getRole().equals(Role.DONG) && !user.getRole().equals(Role.MASTER)) {
            throw UnauthorizedUserException.EXCEPTION;
        }

        dongRepository.deleteById(id);

    }
}

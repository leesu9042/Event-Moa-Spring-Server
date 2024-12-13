package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.dong.exception.DongNotFoundException;
import com.example.eventmoa.domain.dong.persistence.Dong;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.dong.presentation.dto.request.DongCreateRequest;
import com.example.eventmoa.domain.user.exception.UnauthorizedUserException;
import com.example.eventmoa.domain.user.facade.UserFacade;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.role.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DongUpdateService {
    private final DongRepository dongRepository;
    private final UserFacade userFacade;

    @Transactional
    public void update(Long id, DongCreateRequest request) {
        Dong dong = dongRepository.findById(id).orElseThrow(DongNotFoundException::new);
        User user = userFacade.getCurrentUser();

        if(!user.getId().equals(dong.getUser().getId()) && !user.getRole().equals(Role.DONG) && !user.getRole().equals(Role.MASTER)) {
            throw UnauthorizedUserException.EXCEPTION;
        }
        dong.update(id, request);
    }
}
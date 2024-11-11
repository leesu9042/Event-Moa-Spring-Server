package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.dong.persistence.Dong;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.dong.presentation.dto.request.DongCreateRequest;
import com.example.eventmoa.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DongCreateService {
    private final DongRepository dongRepository;
    private final UserFacade userFacade;

    public void create(DongCreateRequest request) {
        dongRepository.save(
                Dong.builder()
                        .user(userFacade.getCurrentUser())
                        .phone(request.getPhone())
                        .place(request.getPlace())
                        .time(request.getTime())
                        .date(request.getDate())
                        .eventName(request.getEventName())
                        .personnel(request.getPersonnel())
                        .dong(request.getDong())
                        .build()
        );
    }
}

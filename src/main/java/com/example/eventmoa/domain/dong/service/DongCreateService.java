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
                        .date(plusZero(request.getDate()))
                        .eventName(request.getEventName())
                        .personnel(request.getPersonnel())
                        .dong(request.getDong())
                        .build()
        );
    }

    private String plusZero(String date){
        String[] day = date.split("\\.");
        String[] time = day[2].split(" ");
        if(day[1].length() == 1){
            day[1] = "0" + day[1];
        }
        if(time[0].length() == 1){
            time[0] = "0" + time[0];
        }
        return day[0] + "." + day[1] + "." + time[0]+" "+time[1];
    }
}

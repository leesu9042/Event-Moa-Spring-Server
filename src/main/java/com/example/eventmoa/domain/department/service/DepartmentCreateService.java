package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.persistence.Department;
import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentCreateRequest;
import com.example.eventmoa.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentCreateService {
    private final DepartmentRepository departmentRepository;
    private final UserFacade userFacade;
    @Transactional
    public void create(DepartmentCreateRequest request) {

        departmentRepository.save(Department.builder()
                        .date(plusZero(request.getDate()))
                        .department(request.getDepartment())
                        .note(request.getNote())
                        .place(request.getPlace())
                        .personnel(request.getPersonnel())
                        .eventName(request.getEventName())
                        .time(request.getTime())
                        .user(userFacade.getCurrentUser())
                .build());
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

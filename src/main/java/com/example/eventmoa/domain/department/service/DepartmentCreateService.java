package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.persistence.Department;
import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentCreateService {
    private final DepartmentRepository departmentRepository;
    @Transactional
    public void create(DepartmentCreateRequest request) {
        departmentRepository.save(Department.builder()
                        .date(request.getDate())
                        .department(request.getDepartment())
                        .note(request.getNote())
                        .place(request.getPlace())
                        .personnel(request.getPersonnel())
                        .eventName(request.getEventName())
                        .time(request.getTime())
                .build());
    }
}

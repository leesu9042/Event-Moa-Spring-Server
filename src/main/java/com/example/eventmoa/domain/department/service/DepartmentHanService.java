package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentQueryhanRequest;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryhanList;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryhanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentHanService {
    private final DepartmentRepository departmentRepository;

    public DepartmentQueryhanResponse queryAll(DepartmentQueryhanRequest request) {
        return new DepartmentQueryhanResponse(departmentRepository.findAllByOrderByDateAscTimeAscDepartmentAsc()
                .stream()
                .filter(d -> getTime(d.getDate()) >= getTime(request.getStartDate()) && getTime(d.getDate()) <= getTime(request.getEndDate()))
                .map(DepartmentQueryhanList::new)
                .toList(),request.getStartDate(),request.getEndDate());
    }


    private long getTime(String date) {
        String[] time = date.split("\\.");
        String[] day = time[2].split(" ");
        return Integer.parseInt((time[0]+time[1]+day[0]));
    }
}

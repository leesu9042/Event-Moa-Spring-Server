package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.persistence.Department;
import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryAllList;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartmentQueryAllService {
    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public DepartmentQueryAllResponse queryAll() {
         return new DepartmentQueryAllResponse(departmentRepository.findAllByOrderByDateAscTimeAscDepartmentAsc()
                .stream()
                .map(DepartmentQueryAllList::new)
                .toList());
    }

}

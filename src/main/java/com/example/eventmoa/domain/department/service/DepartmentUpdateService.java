package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.exception.DepartmentNotFoundException;
import com.example.eventmoa.domain.department.persistence.Department;
import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentCreateRequest;
import com.example.eventmoa.domain.user.exception.UnauthorizedUserException;
import com.example.eventmoa.domain.user.facade.UserFacade;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.role.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentUpdateService {
    private final DepartmentRepository departmentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void update(Long id, DepartmentCreateRequest request){
        Department department = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        User user = userFacade.getCurrentUser();
        if(!user.getId().equals(department.getUser().getId()) && !user.getRole().equals(Role.DEPARTMENT) && !user.getRole().equals(Role.MASTER)){
            throw UnauthorizedUserException.EXCEPTION;
        }

        department.update(id, request);

    }
}

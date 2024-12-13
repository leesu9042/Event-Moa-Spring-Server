package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.exception.DepartmentNotFoundException;
import com.example.eventmoa.domain.department.persistence.Department;
import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.user.facade.UserFacade;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentCheckUserService {
    private final UserFacade userFacade;
    private final DepartmentRepository departmentRepository;

    public boolean check(Long id){
        User user = userFacade.getCurrentUser();
        Department department = departmentRepository.findById(id).orElseThrow(()->DepartmentNotFoundException.EXCEPTION);
        return (user.getRole().equals(Role.DEPARTMENT) || user.getRole().equals(Role.MASTER) || department.getUser().equals(user) );
    }
}

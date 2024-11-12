package com.example.eventmoa.domain.department.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DepartmentQueryAllResponse {
    private List<DepartmentQueryAllList> data;
}

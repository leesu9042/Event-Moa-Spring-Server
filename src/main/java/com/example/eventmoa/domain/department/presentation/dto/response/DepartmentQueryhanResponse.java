package com.example.eventmoa.domain.department.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DepartmentQueryhanResponse {
    private List<DepartmentQueryhanList> data;
    private String startDate;
    private String endDate;
}

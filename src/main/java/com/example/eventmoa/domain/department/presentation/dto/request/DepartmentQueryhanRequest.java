package com.example.eventmoa.domain.department.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentQueryhanRequest {
    private String startDate;
    private String endDate;
}

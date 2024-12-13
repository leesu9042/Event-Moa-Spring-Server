package com.example.eventmoa.domain.dong.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class DongQueryhanResponse {
    private List<DongQueryhanList> data;
    private String startDate;
    private String endDate;
}

package com.example.eventmoa.domain.dong.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DongQueryAllResponse {
    private List<DongQueryAllList> data;
}

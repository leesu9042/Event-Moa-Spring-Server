package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentQueryhanRequest;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryhanList;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryhanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DongHanService {
    private final DongRepository dongRepository;

    public DongQueryhanResponse queryAll(DepartmentQueryhanRequest request) {
        return new DongQueryhanResponse(dongRepository.findAllByOrderByDateAscTimeAscDongAsc()
                .stream()
                .filter(d -> getTime(d.getDate()) >= getTime(request.getStartDate()) && getTime(d.getDate()) <= getTime(request.getEndDate()))
                .map(DongQueryhanList::new)
                .toList(),request.getStartDate(),request.getEndDate());
    }

    private long getTime(String date) {
        String[] time = date.split("\\.");
        String[] day = time[2].split(" ");
        return Integer.parseInt((time[0]+time[1]+day[0]));
    }
}

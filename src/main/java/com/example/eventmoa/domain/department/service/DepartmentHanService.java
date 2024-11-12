package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryhanList;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryhanResponse;
import com.example.eventmoa.domain.dong.presentation.dto.request.DongHanRequest;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryhanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentHanService {
    private final DepartmentRepository departmentRepository;
    private final RestTemplate restTemplate;

    public DepartmentQueryhanResponse queryAll(DongHanRequest request) {
        return new DepartmentQueryhanResponse(departmentRepository.findAllByOrderByDateAscTimeAscDepartmentAsc()
                .stream()
                .filter(d -> getTime(d.getDate()) >= getTime(request.getStartDate()) && getTime(d.getDate()) <= getTime(request.getEndDate()))
                .map(DepartmentQueryhanList::new)
                .toList());
    }

    public ResponseEntity<File> makeHan(DongHanRequest request){
        String url = "http://localhost:9090/test/han";
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(queryAll(request)), File.class);
    }

    private long getTime(String date) {
        date = date.substring(0, 8);
        String[] time = date.split("\\.");
        return Integer.parseInt((time[0]+time[1]+time[2]));
    }
}

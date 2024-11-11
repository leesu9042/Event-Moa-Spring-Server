package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryAllResponse;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DongQueryAllService {
    private final DongRepository dongRepository;

    @Transactional(readOnly = true)
    public List<DongQueryAllResponse> queryAll() {
        return dongRepository.findAllByOrderByDateAscTimeAscDongAsc()
                .stream()
                .map(DongQueryAllResponse::new)
                .toList();
    }
}

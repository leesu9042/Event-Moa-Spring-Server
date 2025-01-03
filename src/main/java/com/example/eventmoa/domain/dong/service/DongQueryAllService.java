package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryAllResponse;
import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryAllList;
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
    public DongQueryAllResponse queryAll() {
        // DB에서 데이터 조회
        var dongList = dongRepository.findAllByOrderByDateAscTimeAscDongAsc();

        // 조회된 데이터를 출력 (디버깅용)
        dongList.forEach(d -> System.out.println("DB Data: " + d));

        // DTO 변환 및 반환
        var responseList = dongList.stream()
                .map(DongQueryAllList::new)
                .toList();

        // 변환된 데이터를 출력 (디버깅용)
        responseList.forEach(d -> System.out.println("Converted Data: " + d));

        return new DongQueryAllResponse(responseList);
    }
}


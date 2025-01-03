package com.example.eventmoa.domain.department.service;

import com.example.eventmoa.domain.department.persistence.repository.DepartmentRepository;
import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentQueryhanRequest;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryhanList;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryhanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DepartmentHanService {
    private final DepartmentRepository departmentRepository;

    public DepartmentQueryhanResponse queryAll(DepartmentQueryhanRequest request) {
        // DB에서 데이터 가져오기
        var departmentList = departmentRepository.findAllByOrderByDateAscTimeAscDepartmentAsc();

        // DB에서 가져온 전체 데이터 출력(디버깅용)
        departmentList.forEach(d -> System.out.println("DB Data: " + d));

        // 시작일과 종료일 LocalDate 변환
        LocalDate start = toLocalDate(request.getStartDate());
        LocalDate end = toLocalDate(request.getEndDate());

        // 스트림 필터링 로직 (LocalDate 사용)
        var filteredList = departmentList.stream()
                .filter(d -> {
                    LocalDate dDate = toLocalDate(d.getDate());
                    // dDate가 start와 end 사이에 있는지 확인
                    return !dDate.isBefore(start) && !dDate.isAfter(end);
                })
                .map(DepartmentQueryhanList::new)
                .toList();

        // 필터링된 데이터 출력(디버깅용)
        filteredList.forEach(d -> System.out.println("DB Data(FILTERED): " + d));

        return new DepartmentQueryhanResponse(filteredList, request.getStartDate(), request.getEndDate());
    }

    // "2024.12.6 (금)" 형태의 날짜 문자열을 LocalDate로 변환
    private LocalDate toLocalDate(String dateStr) {
        // "(금)" 등 요일 제거: 공백 기준으로 앞부분 "2024.12.6"만 추출
        String cleaned = dateStr.split(" ")[0];

        // 패턴: 연도.월.일 (일은 1자리나 2자리 모두 d 패턴으로 처리 가능)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.d");
        return LocalDate.parse(cleaned, formatter);
    }
}

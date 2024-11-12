package com.example.eventmoa.domain.department.presentation.dto.response;

import com.example.eventmoa.domain.department.Departments;
import com.example.eventmoa.domain.department.persistence.Department;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "동행사 조회 응답 dto")
@Getter
public class DepartmentQueryAllList {
    @Schema(description = "기본키")
    private Long id;

    @Schema(description = "행사 이름")
    private String eventName;

    @Schema(description = "행사 일정 / 24.4.7.(월) 형식으로 보낼것")
    private String date;

    @Schema(description = "행사 시각 / 09:00 형식으로 보낼것")
    private String time;

    @Schema(description = "행사 장소")
    private String place;

    @Schema(description = "행사 인원 int value")
    private Long personnel;

    @Schema(description = "행사 주관 과")
    private int department;

    @Schema(description = "비고")
    private String note;

    public DepartmentQueryAllList(Department department) {
        this.id = department.getId();
        this.eventName = department.getEventName();
        this.date = department.getDate();
        this.time = department.getTime();
        this.place = department.getPlace();
        this.personnel = department.getPersonnel();
        this.department = department.getDepartment().ordinal();
        this.note = department.getNote();
    }
}

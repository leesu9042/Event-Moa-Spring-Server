package com.example.eventmoa.domain.department.presentation.dto.request;

import com.example.eventmoa.domain.department.Departments;
import com.example.eventmoa.domain.department.persistence.Department;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Schema(description = "동행사 생성 요청 dto")
@Getter
public class DepartmentCreateRequest {
    @Schema(description = "행사 이름")
    @NotEmpty
    @Size(max = 300)
    private String eventName;

    @Schema(description = "행사 일정 / 24.4.7.(월) 형식으로 보낼것")
    @Size(max = 300)
    @NotEmpty
    private String date;

    @Schema(description = "행사 시각 / 09:00 형식으로 보낼것")
    @Size(max = 7)
    @NotEmpty
    private String time;

    @Schema(description = "행사 장소")
    @Size(max = 300)
    @NotEmpty
    private String place;

    @Schema(description = "행사 인원 int value")
    @Min(value = 1)
    private Long personnel;

    @Schema(description = "행사 주관 과")
    @NotNull
    private Departments department;

    @Schema(description = "비고")
    @Size(max = 500)
    private String note;


}

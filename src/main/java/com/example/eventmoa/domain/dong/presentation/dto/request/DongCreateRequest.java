package com.example.eventmoa.domain.dong.presentation.dto.request;

import com.example.eventmoa.domain.department.Departments;
import com.example.eventmoa.domain.dong.Dongs;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Schema
public class DongCreateRequest {
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

    @Schema(description = "행사 주관 동/ 보내준 jpg 파일을 참고해 숫자로 보낼 것")
    @NotNull
    private Dongs dong;

    @Schema(description = "연락처 / '박상철 010-1234-1234' 형식으로 보낼것")
    @Size(max = 500)
    private String phone;
}

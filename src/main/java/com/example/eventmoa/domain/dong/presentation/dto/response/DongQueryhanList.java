package com.example.eventmoa.domain.dong.presentation.dto.response;

import com.example.eventmoa.domain.dong.Dongs;
import com.example.eventmoa.domain.dong.persistence.Dong;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DongQueryhanList {
    @Schema(description = "행사 이름")
    @NotEmpty
    @Size(max = 300)
    private String eventName;

    @Size(max = 300)
    @NotEmpty
    private String date;

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

    @NotNull
    private String  dong;

    @Size(max = 500)
    private String phone;

    public DongQueryhanList(Dong dong) {
        this.eventName = dong.getEventName();
        this.date = dong.getDate();
        this.dong = dong.getDong().getName();
        this.time = dong.getTime();
        this.place = dong.getPlace();
        this.personnel = dong.getPersonnel();
        this.phone = dong.getPhone();
    }
}

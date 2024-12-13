package com.example.eventmoa.domain.dong.presentation.dto.response;


import com.example.eventmoa.domain.dong.Dongs;
import com.example.eventmoa.domain.dong.persistence.Dong;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class DongQueryAllList {
    private Long id;

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
    private Dongs dong;

    @Size(max = 500)
    private String phone;

    public DongQueryAllList(Dong dong) {
        this.id = dong.getId();
        this.eventName = dong.getEventName();
        this.date = dong.getDate();
        this.time = dong.getTime();
        this.place = dong.getPlace();
        this.personnel = dong.getPersonnel();
        this.dong = dong.getDong();
        this.phone = dong.getPhone();
    }
}

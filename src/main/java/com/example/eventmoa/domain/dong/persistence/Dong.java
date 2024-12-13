package com.example.eventmoa.domain.dong.persistence;

import com.example.eventmoa.domain.department.Departments;
import com.example.eventmoa.domain.dong.Dongs;
import com.example.eventmoa.domain.dong.presentation.dto.request.DongCreateRequest;
import com.example.eventmoa.domain.user.persistence.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "tbl_dong")
public class Dong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private Long personnel;

    @Column(nullable = false)
    private Dongs dong;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private String phone;

    public void update(Long id, DongCreateRequest request) {
        this.id = id;
        this.eventName = request.getEventName();
        this.date = plusZero(request.getDate());
        this.time = request.getTime();
        this.place = request.getPlace();
        this.personnel = request.getPersonnel();
        this.dong = request.getDong();
        this.phone = request.getPhone();
    }

    private String plusZero(String date){
        String[] day = date.split("\\.");
        String[] time = day[2].split(" ");
        if(day[1].length() == 1){
            day[1] = "0" + day[1];
        }
        if(time[0].length() == 1){
            time[0] = "0" + time[0];
        }
        return day[0] + "." + day[1] + "." + time[0]+" "+time[1];
    }

}

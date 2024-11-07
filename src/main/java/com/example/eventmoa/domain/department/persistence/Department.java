package com.example.eventmoa.domain.department.persistence;

import com.example.eventmoa.domain.department.Departments;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private Long personnel;

    @Column(nullable = false)
    private Departments department;

    @Column(nullable = false)
    private String note;
}

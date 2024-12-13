package com.example.eventmoa.domain.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum Departments {
    // 감사실
    AUDIT_OFFICE("감사실","감사실"),

    // 기획재정국
    PLANNING_BUDGET("기획예산과", "기획재정국"),
    PUBLIC_RELATIONS("홍보과", "기획재정국"),
    TAXATION("세정과", "기획재정국"),
    TAX_MANAGEMENT("세원관리과", "기획재정국"),

    // 자치행정국
    ADMIN_SUPPORT("운영지원과", "자치행정국"),
    VILLAGE_AUTONOMY("마을자치과", "자치행정국"),
    ACCOUNTING("회계과", "자치행정국"),
    CIVIL_PASSPORT("민원여관과", "자치행정국"),
    LAND_INFORMATION("토지정보과", "자치행정국"),

    // 경제문화국
    JOB_POLICY("일자리정책과", "경제문화국"),
    CULTURE_TOURISM_SPORTS("문화관광체육과", "경제문화국"),
    EDUCATION_SCIENCE("교육과학과", "경제문화국"),
    LOCAL_INDUSTRY("지역산업과", "경제문화국"),

    // 주민복지국
    SOCIAL_CARE("사회돌봄과", "주민복지국"),
    ELDERLY_DISABLED("노인장애인과", "주민복지국"),
    LIVING_SECURITY("생활보장과", "주민복지국"),
    CHILD_WELFARE("아동복지과", "주민복지국"),
    SANITATION("위생과", "주민복지국"),

    // 생활환경국
    GREEN_ENVIRONMENT("푸른환경과", "생활환경국"),
    CLEAN_ADMINISTRATION("청소행정과", "생활환경국"),
    TRAFFIC_POLICY("교통정책과", "생활환경국"),
    PARKING_MANAGEMENT("주차관리과", "생활환경국"),
    PARKS("공원과", "생활환경국"),
    FORESTRY("녹지산림과", "생활환경국"),

    // 안전도시국
    URBAN_PLANNING("도시계획과", "안전도시국"),
    DISASTER_SAFETY("재난안전과", "안전도시국"),
    CONSTRUCTION("건설과", "안전도시국"),
    ARCHITECTURE("건축과", "안전도시국"),
    JOINT_HOUSING("공동주택과", "안전도시국"),

    // 보건소
    PUBLIC_HEALTH_PHARMACY("보건의약과", "보건소"),
    HEALTH_POLICY("건강정책과", "보건소"),

    // 평생학습원
    LIFELONG_LEARNING("평생학습과", "평생학습원"),
    LIBRARY_MANAGEMENT("도서관운영과", "평생학습원");

    private final String departmentName;
    private final String Bureau;

}

package com.example.eventmoa.domain.dong;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Dongs {
    JINJAM_DONG("진잠동"),
    HAKHA_DONG("학하동"),
    WONSHINHEUNG_DONG("원신흥동"),
    SANGDAE_DONG("상대동"),
    ONCHEON1_DONG("온천1동"),
    ONCHEON2_DONG("온천2동"),
    NOEUN1_DONG("노은1동"),
    NOEUN2_DONG("노은2동"),
    NOEUN3_DONG("노은3동"),
    SINSEONG_DONG("신성동"),
    JEONMIN_DONG("전민동"),
    GUJEUK_DONG("구즉동"),
    GWANRYEONG_DONG("관령동");

    private final String name;
}

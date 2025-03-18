package com.vinns.dashboard.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Score {

    @Id
    @Column(name="seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int seq;

    @Column(name = "value")
    int value;

    @Column(name = "student")
    int studentNo;

    @Column(name = "lecture")
    int lectureNo;


    @Builder
    public Score(int value, int studentNo, int lectureNo){
        this.value = value;
        this.studentNo = studentNo;
        this.lectureNo = lectureNo;
    }
}

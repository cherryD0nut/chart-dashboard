package com.vinns.dashboard.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Lecture {

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;

    @Column(name = "title")
    String title;

    @Column(name = "subject")
    String subject;

    @Builder
    public Lecture(int seq, String title, String subject){
        this.seq = seq;
        this.title = title;
        this.subject = subject;
    }

}

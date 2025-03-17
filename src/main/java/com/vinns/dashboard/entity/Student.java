package com.vinns.dashboard.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "level")
    private int level;

    @Column(name = "track")
    private int track;

    @Builder
    public Student(String name, String gender, int level, int track){
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.track = track;
    }
}

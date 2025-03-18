package com.vinns.dashboard.dto;

import com.vinns.dashboard.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StudentDto {

    private String name;

    private String gender;

    private int level;

    private int track;

    public StudentDto(Student student){
        this.name = student.getName();
        this.gender = student.getGender();
        this.level = student.getLevel();
        this.track = student.getTrack();
    }
}

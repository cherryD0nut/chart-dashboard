package com.vinns.dashboard.controller;

import com.vinns.dashboard.dto.StudentDto;
import com.vinns.dashboard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/table")
public class TableController {
    private final StudentService studentService;

    @GetMapping(value="/all")
    public ResponseEntity<List<StudentDto>> findAllStudents(){
        List<StudentDto> students = studentService.findAll()
                .stream()
                .map(StudentDto::new)
                .toList();

        return ResponseEntity.ok()
                .body(students);
    }


}

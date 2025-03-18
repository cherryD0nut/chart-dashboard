package com.vinns.dashboard.controller;

import com.vinns.dashboard.dto.StudentDto;
import com.vinns.dashboard.entity.Student;
import com.vinns.dashboard.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;

    @GetMapping(value="/")
    public ResponseEntity<List<StudentDto>> findAllStudents(){
        List<StudentDto> students = studentService.findAll()
                .stream()
                .map(StudentDto::new)
                .toList();

        return ResponseEntity.ok()
                .body(students);
    }
}

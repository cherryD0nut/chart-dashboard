package com.vinns.dashboard.repository;

import com.vinns.dashboard.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
}

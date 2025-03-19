package com.vinns.dashboard.repository;

import com.vinns.dashboard.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}

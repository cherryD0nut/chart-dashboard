package com.vinns.dashboard.repository;

import com.vinns.dashboard.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
}

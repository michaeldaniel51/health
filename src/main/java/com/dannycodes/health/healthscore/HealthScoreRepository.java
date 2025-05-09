package com.dannycodes.health.healthscore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthScoreRepository extends JpaRepository<HealthScore, Long> {
}

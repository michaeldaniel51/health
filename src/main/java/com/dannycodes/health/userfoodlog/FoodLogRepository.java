package com.dannycodes.health.userfoodlog;

import com.dannycodes.health.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {
    List<FoodLog> findByUserAndConsumedAtBetween(User user, LocalDateTime start, LocalDateTime end);
     List<FoodLog> findByUserId(Long userId);

}

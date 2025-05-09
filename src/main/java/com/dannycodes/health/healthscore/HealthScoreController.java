package com.dannycodes.health.healthscore;


import com.dannycodes.health.fooditem.FoodItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
public class HealthScoreController {


    private final HealthScoreService healthScoreService;

    public HealthScoreController(HealthScoreService healthScoreService) {
        this.healthScoreService = healthScoreService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<HealthScore> getTodayScore(@PathVariable Long userId) {
        return ResponseEntity.ok(healthScoreService.evaluateUserDailyHealth(userId));
    }

}

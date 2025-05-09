package com.dannycodes.health.userfoodlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class FoodLogController {

    private final FoodLogService foodLogService;

    public FoodLogController(FoodLogService foodLogService) {
        this.foodLogService = foodLogService;
    }

    @PostMapping
    public ResponseEntity<FoodLog> logFood(@RequestParam Long userId, @RequestParam Long foodItemId, @RequestParam Double quantity) {
        return ResponseEntity.ok(foodLogService.logFood(userId, foodItemId, quantity));
    }

    @GetMapping("/history/{userId}")
    public List<FoodLog> history(@PathVariable Long userId) {
        return foodLogService.history(userId);
    }

}

package com.dannycodes.health.fooditem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public ResponseEntity<FoodItem> addFood(@RequestBody FoodItem foodItem) {
        return ResponseEntity.ok(foodItemService.saveFoodItem(foodItem));
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFood() {
        return ResponseEntity.ok(foodItemService.getAllFoodItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FoodItem>> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodItemService.getFoodItemById(id));
    }

}

package com.dannycodes.health;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/food")
//@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @PostMapping()
    public Food addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @PostMapping("/combinations")
    public Map<String, Object> checkCombination(@RequestBody FoodChecker foodChecker) {
       return foodService.checkCombination(foodChecker);
    }

}

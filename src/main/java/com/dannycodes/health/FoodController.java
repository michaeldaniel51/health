package com.dannycodes.health;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "http://localhost:3000")
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
    @PutMapping("/edit/{id}")
    public Food updateFood(@PathVariable Long id,@RequestBody Food updatedFood) {
        return foodService.updateFood(id,updatedFood);
    }

    @PostMapping("/combinations")
    public Map<String, Object> checkCombination(@RequestBody FoodChecker foodChecker) {
       return foodService.checkCombination(foodChecker);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id ) {
       return foodService.deleteFood(id);
    }
    @GetMapping("/single/{id}")
    public Food getFoodById(@PathVariable Long id ) {
       return foodService.getFoodById(id);
    }

}

package com.dannycodes.health;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class FoodService {

    @Autowired
    private FoodRepository foodRepo;

    public List<Food> getAllFoods() {
        return foodRepo.findAll();
    }


    public Food addFood(Food food) {
        return foodRepo.save(food);
    }

    public Map<String, Object> checkCombination(FoodChecker foodChecker) {
        List<Food> foods = foodRepo.findAllById(foodChecker.getFoodIds());
        int totalCalories = foods.stream()
                .mapToInt(Food::getCalories)
                .sum();
        Map<String, Object> result = new HashMap<>();
        result.put("totalCalories", totalCalories);
        result.put("healthy", totalCalories <= 700); // You can change the threshold
        return result;
    }

    public String deleteFood(Long id) {
        Food food = foodRepo.findById(id).orElseThrow();
         foodRepo.deleteById(id);
        return food.getName() + " Was Deleted Successfully";
    }


}

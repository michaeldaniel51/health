package com.dannycodes.health.fooditem;

import com.dannycodes.health.Food;
import com.dannycodes.health.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    public FoodItem saveFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public String deleteFoodItem(Long id) {
        Optional<FoodItem> foodItem = getFoodItemById(id);
        foodItemRepository.deleteById(id);
       return foodItem.get().getName() +" is deleted Successfully";
    }


    public FoodItem updateFoodItem(Long id, FoodItem updatedFoodItem) {
        return foodItemRepository.findById(id).map(existingFood -> {
            existingFood.setName(updatedFoodItem.getName());
            existingFood.setCalories(updatedFoodItem.getCalories());
            existingFood.setCarbs(updatedFoodItem.getCarbs());
            existingFood.setProtein(updatedFoodItem.getProtein());
            existingFood.setFat(updatedFoodItem.getFat());
            existingFood.setSugar(updatedFoodItem.getSugar());
            // Add other fields as necessary
            return foodItemRepository.save(existingFood);
        }).orElseThrow(() -> new GeneralException("FoodItem not found with id " + id));
    }


}

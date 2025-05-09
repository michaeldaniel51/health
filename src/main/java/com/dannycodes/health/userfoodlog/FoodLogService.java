package com.dannycodes.health.userfoodlog;

import com.dannycodes.health.fooditem.FoodItem;
import com.dannycodes.health.fooditem.FoodItemRepository;
import com.dannycodes.health.user.User;
import com.dannycodes.health.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodLogService {

    private final FoodLogRepository foodLogRepository;
    private final UserRepository userRepository;
    private final FoodItemRepository foodItemRepository;

    public FoodLogService(FoodLogRepository foodLogRepository, UserRepository userRepository, FoodItemRepository foodItemRepository) {
        this.foodLogRepository = foodLogRepository;
        this.userRepository = userRepository;
        this.foodItemRepository = foodItemRepository;
    }

    public FoodLog logFood(Long userId, Long foodItemId, Double quantity) {
        User user = userRepository.findById(userId).orElseThrow();
        FoodItem food = foodItemRepository.findById(foodItemId).orElseThrow();

        FoodLog log = new FoodLog();
        log.setUser(user);
        log.setFoodItem(food);
        log.setQuantity(quantity);
        log.setConsumedAt(LocalDateTime.now());

        return foodLogRepository.save(log);
    }


    public List<FoodLog> history(Long userId) {
        return foodLogRepository.findByUserId(userId);
    }

}





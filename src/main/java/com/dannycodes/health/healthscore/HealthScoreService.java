package com.dannycodes.health.healthscore;

import com.dannycodes.health.fooditem.FoodItem;
import com.dannycodes.health.healthrule.HealthRule;
import com.dannycodes.health.healthrule.HealthRuleRepository;
import com.dannycodes.health.user.User;
import com.dannycodes.health.user.UserRepository;
import com.dannycodes.health.userfoodlog.FoodLog;
import com.dannycodes.health.userfoodlog.FoodLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class HealthScoreService {


    private final FoodLogRepository foodLogRepository;
    private final HealthScoreRepository healthScoreRepository;
    private final UserRepository userRepository;

    @Autowired
    private HealthRuleRepository ruleRepository;


    public HealthScoreService(FoodLogRepository foodLogRepository, HealthScoreRepository healthScoreRepository, UserRepository userRepository) {
        this.foodLogRepository = foodLogRepository;
        this.healthScoreRepository = healthScoreRepository;
        this.userRepository = userRepository;
    }


    public HealthScore evaluateUserDailyHealth(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(LocalTime.MAX);

        List<FoodLog> logs = foodLogRepository.findByUserAndConsumedAtBetween(user, start, end);
        List<HealthRule> rules = ruleRepository.findAll();

        double score = 100.0;
        StringBuilder feedback = new StringBuilder();

        for (HealthRule rule : rules) {
            double totalNutrient = 0.0;

            for (FoodLog log : logs) {
                FoodItem item = log.getFoodItem();
                Double valuePer100g = getNutrientValue(item, rule.getNutrientName());
                if (valuePer100g != null) {
                    double actualValue = valuePer100g * log.getQuantity() / 100;
                    totalNutrient += actualValue;
                }
            }

            boolean violated = false;
            if (rule.getMinRecommended() != null && totalNutrient < rule.getMinRecommended()) {
                violated = true;
            }
            if (rule.getMaxRecommended() != null && totalNutrient > rule.getMaxRecommended()) {
                violated = true;
            }

            if (violated) {
                score -= 10;
                feedback.append(String.format("Daily %s (%.2f %s) is outside healthy range (%.2f - %.2f %s). %s%n",
                        rule.getNutrientName(), totalNutrient, rule.getUnit(),
                        rule.getMinRecommended(), rule.getMaxRecommended(), rule.getUnit(),
                        rule.getDescription()
                ));
            }
        }

        score = Math.max(score, 0);

        HealthScore healthScore = new HealthScore();
        healthScore.setUser(user);
        healthScore.setDate(today);
        healthScore.setScore(score);
        healthScore.setFeedback(feedback.toString());

        return healthScoreRepository.save(healthScore);
    }


    private Double getNutrientValue(FoodItem item, String nutrientName) {
        switch (nutrientName.toLowerCase()) {
            case "calories": return item.getCalories();
            case "sugar": return item.getSugar();
            case "fat": return item.getFat();
            case "protein": return item.getProtein();
            default: return null;
        }
    }


}

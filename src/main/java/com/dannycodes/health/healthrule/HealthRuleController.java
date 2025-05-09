package com.dannycodes.health.healthrule;

import com.dannycodes.health.fooditem.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health/rule")
public class HealthRuleController {

    @Autowired
    private HealthRuleRepository healthRuleRepository;

    @PostMapping
    public ResponseEntity<HealthRule> addFood(@RequestBody HealthRule healthRule) {
        return ResponseEntity.ok(healthRuleRepository.save(healthRule));
    }

    @GetMapping
    public ResponseEntity<List<HealthRule>> getAllHealthRule() {
        return ResponseEntity.ok(healthRuleRepository.findAll());
    }


}

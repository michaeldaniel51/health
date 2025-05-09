package com.dannycodes.health.healthrule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class HealthRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nutrientName; // e.g. "calories", "sugar", "fat"

    private Double minRecommended; // nullable
    private Double maxRecommended; // nullable

    private String unit; // e.g. "kcal", "g"

    private String impact; // e.g. "negative", "positive"

    private String description;

    public Long getId() {
        return id;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public Double getMinRecommended() {
        return minRecommended;
    }

    public Double getMaxRecommended() {
        return maxRecommended;
    }

    public String getUnit() {
        return unit;
    }

    public String getImpact() {
        return impact;
    }

    public String getDescription() {
        return description;
    }
}

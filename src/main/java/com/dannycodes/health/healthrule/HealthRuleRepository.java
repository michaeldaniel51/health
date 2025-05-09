package com.dannycodes.health.healthrule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthRuleRepository extends JpaRepository<HealthRule, Long> {
    List<HealthRule> findAll();



}

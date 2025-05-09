package com.dannycodes.health.healthscore;

import com.dannycodes.health.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class HealthScore {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    private LocalDateTime calculatedAt;
    private double score;
    private String summary;
    private String feedback;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public double getScore() {
        return score;
    }

    public String getSummary() {
        return summary;
    }

    public String getFeedback() {
        return feedback;
    }

    public LocalDate getDate() {
        return date;
    }
}

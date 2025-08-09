package com.university.grading.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class GradeRequest {
    
    @NotNull(message = "Total points cannot be null")
    @Min(value = 0, message = "Total points must be at least 0")
    @Max(value = 1000, message = "Total points cannot exceed 1000")
    private Integer totalPoints;

    // Default constructor
    public GradeRequest() {
    }

    // Parameterized constructor
    public GradeRequest(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    // Getter
    public Integer getTotalPoints() {
        return totalPoints;
    }

    // Setter
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "GradeRequest{" +
                "totalPoints=" + totalPoints +
                '}';
    }
}
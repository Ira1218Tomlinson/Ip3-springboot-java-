package com.university.grading.service;

import com.university.grading.dto.GradeResponse;
import org.springframework.stereotype.Service;

@Service
public class GradingService {

    /**
     * Calculate letter grade based on total points
     * @param totalPoints the total points achieved
     * @return GradeResponse containing the letter grade and description
     */
    public GradeResponse calculateGrade(Integer totalPoints) {
        String letterGrade;
        String description;

        if (totalPoints >= 900 && totalPoints <= 1000) {
            letterGrade = "A";
            description = "Excellent";
        } else if (totalPoints >= 800 && totalPoints < 900) {
            letterGrade = "B";
            description = "Good";
        } else if (totalPoints >= 700 && totalPoints < 800) {
            letterGrade = "C";
            description = "Satisfactory";
        } else {
            letterGrade = "F";
            description = "Fail";
        }

        return new GradeResponse(totalPoints, letterGrade, description);
    }

    /**
     * Validate if the total points are within acceptable range
     * @param totalPoints the total points to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidPoints(Integer totalPoints) {
        return totalPoints != null && totalPoints >= 0 && totalPoints <= 1000;
    }
}
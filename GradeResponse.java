package com.university.grading.dto;

public class GradeResponse {
    
    private Integer totalPoints;
    private String letterGrade;
    private String description;

    // Default constructor
    public GradeResponse() {
    }

    // Parameterized constructor
    public GradeResponse(Integer totalPoints, String letterGrade, String description) {
        this.totalPoints = totalPoints;
        this.letterGrade = letterGrade;
        this.description = description;
    }

    // Getters
    public Integer getTotalPoints() {
        return totalPoints;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GradeResponse{" +
                "totalPoints=" + totalPoints +
                ", letterGrade='" + letterGrade + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
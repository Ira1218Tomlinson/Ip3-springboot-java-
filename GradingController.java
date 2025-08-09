package com.university.grading.controller;

import com.university.grading.dto.GradeRequest;
import com.university.grading.dto.GradeResponse;
import com.university.grading.service.GradingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grading")
@CrossOrigin(origins = "*")
public class GradingController {

    private final GradingService gradingService;

    @Autowired
    public GradingController(GradingService gradingService) {
        this.gradingService = gradingService;
    }

    /**
     * Calculate grade based on total points
     * POST /api/v1/grading/calculate
     */
    @PostMapping("/calculate")
    public ResponseEntity<GradeResponse> calculateGrade(@Valid @RequestBody GradeRequest request) {
        try {
            GradeResponse response = gradingService.calculateGrade(request.getTotalPoints());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Calculate grade based on total points (GET method for simple queries)
     * GET /api/v1/grading/calculate?totalPoints=850
     */
    @GetMapping("/calculate")
    public ResponseEntity<GradeResponse> calculateGradeByParams(@RequestParam Integer totalPoints) {
        try {
            if (!gradingService.isValidPoints(totalPoints)) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            
            GradeResponse response = gradingService.calculateGrade(totalPoints);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Health check endpoint
     * GET /api/v1/grading/health
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Grading Microservice is running!", HttpStatus.OK);
    }
}
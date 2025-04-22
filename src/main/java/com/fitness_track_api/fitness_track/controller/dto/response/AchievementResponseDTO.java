package com.fitness_track_api.fitness_track.controller.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AchievementResponseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate achievedDate;
    private Long userId;
    private String username;
    private Long workoutPlanId;
    private String workoutPlanName;
}

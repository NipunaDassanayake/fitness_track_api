package com.fitness_track_api.fitness_track.controller.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkoutPlanResponseDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Long creatorId;
    private List<ExerciseResponseDTO> exercises;
}

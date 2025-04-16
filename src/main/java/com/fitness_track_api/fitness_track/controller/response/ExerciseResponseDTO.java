package com.fitness_track_api.fitness_track.controller.response;

import lombok.Data;

@Data
public class ExerciseResponseDTO {
    private Long id;
    private String name;
    private String description;
    private boolean isCompleted;
    private Integer order;
}
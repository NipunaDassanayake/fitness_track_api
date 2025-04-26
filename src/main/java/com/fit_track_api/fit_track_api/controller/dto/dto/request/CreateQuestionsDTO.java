package com.fitness_track_api.fitness_track.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CreateQuestionsDTO {
    private Long workoutPlanId;
    private List<String> questions;
}

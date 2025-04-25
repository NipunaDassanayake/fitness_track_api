package com.fitness_track_api.fitness_track.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SubmitAnswerDTO {
    private Long userId;
    private Long questionnaireId;
    private String answer;
}

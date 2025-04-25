package com.fitness_track_api.fitness_track.controller.response;

import lombok.Data;

@Data
public class GetUserByIdResponseDTO {
    private Long id;
    private String username;
    private String email;

}

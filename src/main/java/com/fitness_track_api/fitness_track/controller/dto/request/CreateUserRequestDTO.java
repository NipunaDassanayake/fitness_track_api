package com.fitness_track_api.fitness_track.controller.request;

import lombok.Data;

@Data
public class CreateUserRequestDTO {

    private String username;
    private String email;
    private String password;

}

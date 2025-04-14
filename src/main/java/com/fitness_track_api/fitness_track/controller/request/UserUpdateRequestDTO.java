package com.fitness_track_api.fitness_track.controller.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserUpdateRequestDTO {

    private String username;
    private String email;
    private MultipartFile profilePicture;
}

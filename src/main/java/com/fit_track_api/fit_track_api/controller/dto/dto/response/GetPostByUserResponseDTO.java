package com.fitness_track_api.fitness_track.controller.dto.response;

import com.fitness_track_api.fitness_track.model.User;
import lombok.Data;

import java.util.List;

@Data
public class GetPostByUserResponseDTO {
    private String title;
    private String description;
    private List<String> imageUrls;
    private List<GetUserByIdResponseDTO> likedBy;
}

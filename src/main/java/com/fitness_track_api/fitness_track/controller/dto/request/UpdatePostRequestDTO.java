package com.fitness_track_api.fitness_track.controller.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UpdatePostRequestDTO {
    private String title;
    private String description;
    private List<MultipartFile> imageUrls;
}

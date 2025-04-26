package com.fitness_track_api.fitness_track.controller.dto.request;

import com.fitness_track_api.fitness_track.model.User;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreatePostRequestDTO {

    private String title;
    private String description;
    private List<MultipartFile> imageUrls;

}

package com.fitness_track_api.fitness_track.controller.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class GetCommentResponseDTO {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Long userId;
    private String username;
    private Long achievementId;

    public GetCommentResponseDTO(Long id, String content, LocalDateTime createdAt, String username) {
    }

    public GetCommentResponseDTO() {

    }
}
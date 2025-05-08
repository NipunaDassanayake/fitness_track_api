package com.fitness_track_api.fitness_track.controller;


import com.fit_track_api.fit_track_api.controller.dto.request.CreateCommentRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetCommentResponseDTO;
import com.fit_track_api.fit_track_api.model.Comment;
import com.fit_track_api.fit_track_api.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
public class CommentController {


    private CommentService commentService;


    @PostMapping("/achievement/{achievementId}/user/{userId}")
    public ResponseEntity<String> addComment(@PathVariable Long achievementId , @PathVariable Long userId , @RequestBody CreateCommentRequestDTO createCommentRequestDTO){
         commentService.addComment(achievementId,userId,createCommentRequestDTO);
        return ResponseEntity.ok("Comment added successfully");
    }




}

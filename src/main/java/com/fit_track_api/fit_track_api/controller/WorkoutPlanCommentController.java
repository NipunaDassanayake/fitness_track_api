package com.fit_track_api.fit_track_api.controller;

import com.fit_track_api.fit_track_api.controller.dto.request.CreateCommentRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdateCommentRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetWorkoutPlanCommentResponseDTO;
import com.fit_track_api.fit_track_api.model.WorkoutPlanComment;
import com.fit_track_api.fit_track_api.service.WorkoutPlanCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutPlans")
@AllArgsConstructor
public class WorkoutPlanCommentController {

    private final WorkoutPlanCommentService commentService;

    @PostMapping("/{workoutPlanId}/comments")
    public ResponseEntity<WorkoutPlanComment> addComment(
            @PathVariable Long workoutPlanId,
            @RequestParam Long userId,
            @RequestBody CreateCommentRequestDTO createCommentRequestDTO) {
        WorkoutPlanComment comment = commentService.addComment(workoutPlanId, userId, createCommentRequestDTO);
        return ResponseEntity.ok(comment);
    }


}

package com.fit_track_api.fit_track_api.service.impl;

import com.fit_track_api.fit_track_api.controller.dto.request.CreateCommentRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdateCommentRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetWorkoutPlanCommentResponseDTO;
import com.fit_track_api.fit_track_api.model.User;
import com.fit_track_api.fit_track_api.model.WorkoutPlan;
import com.fit_track_api.fit_track_api.model.WorkoutPlanComment;
import com.fit_track_api.fit_track_api.repository.UserRepository;
import com.fit_track_api.fit_track_api.repository.WorkoutPlanCommentRepository;
import com.fit_track_api.fit_track_api.repository.WorkoutPlanRepository;
import com.fit_track_api.fit_track_api.service.WorkoutPlanCommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkoutPlanCommentServiceImpl implements WorkoutPlanCommentService {

    private final WorkoutPlanCommentRepository workoutPlanCommentRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final UserRepository userRepository;

    @Override
    public WorkoutPlanComment addComment(Long workoutPlanId, Long userId, CreateCommentRequestDTO dto) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(workoutPlanId)
                .orElseThrow(() -> new RuntimeException("WorkoutPlan not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        WorkoutPlanComment comment = new WorkoutPlanComment();
        comment.setContent(dto.getContent());
        comment.setWorkoutPlan(workoutPlan);
        comment.setUser(user);

        return workoutPlanCommentRepository.save(comment);
    }


}

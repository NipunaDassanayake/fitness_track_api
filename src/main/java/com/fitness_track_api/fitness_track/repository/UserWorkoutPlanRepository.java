package com.fitness_track_api.fitness_track.repository;

import com.fitness_track_api.fitness_track.model.UserWorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWorkoutPlanRepository extends JpaRepository<UserWorkoutPlan, Long> {
    UserWorkoutPlan findByUserIdAndWorkoutPlanId(Long userId, Long workoutPlanId);
}

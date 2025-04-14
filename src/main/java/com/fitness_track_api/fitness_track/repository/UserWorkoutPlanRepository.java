package com.fitness_track_api.fitness_track.repository;

import com.fit_track_api.fit_track_api.model.UserWorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWorkoutPlanRepository extends JpaRepository<UserWorkoutPlan, Long> {
    UserWorkoutPlan findByUserIdAndWorkoutPlanId(Long userId, Long workoutPlanId);
}

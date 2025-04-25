package com.fitness_track_api.fitness_track.repository;

import com.fit_track_api.fit_track_api.model.UserExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExerciseRepository extends JpaRepository<UserExercise,Long> {
    UserExercise findByUserWorkoutPlanIdAndExerciseId(Long id, Long exerciseId);
}

package com.fit_track_api.fit_track_api.repository;

import com.fitness_track_api.fitness_track.model.UserExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExerciseRepository extends JpaRepository<UserExercise,Long> {
    UserExercise findByUserWorkoutPlanIdAndExerciseId(Long id, Long exerciseId);

    Iterable<? extends UserExercise> findByUserWorkoutPlanId(Long id);
}

package com.fitness_track_api.fitness_track.repository;

import com.fitness_track_api.fitness_track.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    List<Questionnaire> findByWorkoutPlanId(Long workoutPlanId);
}


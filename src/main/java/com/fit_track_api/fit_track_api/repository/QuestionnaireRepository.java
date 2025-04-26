<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/repository/QuestionnaireRepository.java
package com.fitness_track_api.fitness_track.repository;

import com.fitness_track_api.fitness_track.model.Questionnaire;
=======
package com.fit_track_api.fit_track_api.repository;

import com.fit_track_api.fit_track_api.model.Questionnaire;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/repository/QuestionnaireRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    List<Questionnaire> findByWorkoutPlanId(Long workoutPlanId);
}


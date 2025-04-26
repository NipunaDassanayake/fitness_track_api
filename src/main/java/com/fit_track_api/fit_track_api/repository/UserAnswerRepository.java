<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/repository/UserAnswerRepository.java
package com.fitness_track_api.fitness_track.repository;

import com.fitness_track_api.fitness_track.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
=======
package com.fit_track_api.fit_track_api.repository;

import com.fit_track_api.fit_track_api.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findByQuestionnaireId(Long questionId);
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/repository/UserAnswerRepository.java
}

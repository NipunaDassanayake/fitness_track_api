<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/service/QuestionnaireService.java
package com.fitness_track_api.fitness_track.service;

import com.fitness_track_api.fitness_track.controller.dto.request.CreateQuestionsDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.QuestionDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitAnswerDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitBulkAnswersDTO;
import com.fitness_track_api.fitness_track.model.Questionnaire;
import com.fitness_track_api.fitness_track.model.UserAnswer;
=======
package com.fit_track_api.fit_track_api.service;

import com.fit_track_api.fit_track_api.controller.dto.request.*;
import com.fit_track_api.fit_track_api.model.Questionnaire;
import com.fit_track_api.fit_track_api.model.UserAnswer;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/service/QuestionnaireService.java
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionnaireService {
    public List<QuestionDTO> createQuestionsForWorkoutPlan(CreateQuestionsDTO createQuestionsDTO) ;
    public List<QuestionDTO> getQuestionsForWorkoutPlan(Long workoutPlanId);
    public UserAnswer submitAnswer(SubmitAnswerDTO submitAnswerDTO);
    public List<UserAnswer> submitBulkAnswers(SubmitBulkAnswersDTO submitBulkAnswersDTO);
<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/service/QuestionnaireService.java
=======
    void deleteQuestionById(Long questionId);
    QuestionDTO updateQuestion(UpdateQuestionDTO updateQuestionDTO);

>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/service/QuestionnaireService.java
}
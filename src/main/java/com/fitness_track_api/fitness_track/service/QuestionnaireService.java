package com.fitness_track_api.fitness_track.service;

import com.fitness_track_api.fitness_track.controller.dto.request.CreateQuestionsDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.QuestionDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitAnswerDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitBulkAnswersDTO;
import com.fitness_track_api.fitness_track.model.Questionnaire;
import com.fitness_track_api.fitness_track.model.UserAnswer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionnaireService {
    public List<QuestionDTO> createQuestionsForWorkoutPlan(CreateQuestionsDTO createQuestionsDTO) ;
    public List<QuestionDTO> getQuestionsForWorkoutPlan(Long workoutPlanId);
    public UserAnswer submitAnswer(SubmitAnswerDTO submitAnswerDTO);
    public List<UserAnswer> submitBulkAnswers(SubmitBulkAnswersDTO submitBulkAnswersDTO);
}
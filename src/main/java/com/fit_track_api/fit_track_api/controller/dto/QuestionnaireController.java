package com.fitness_track_api.fitness_track.controller;

import com.fitness_track_api.fitness_track.controller.dto.request.CreateQuestionsDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.QuestionDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitAnswerDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitBulkAnswersDTO;
import com.fitness_track_api.fitness_track.model.Questionnaire;
import com.fitness_track_api.fitness_track.model.UserAnswer;
import com.fitness_track_api.fitness_track.service.QuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/questions")
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;

    @PostMapping
    // Bulk create questions for a workout plan and return them as DTOs
    public ResponseEntity<List<QuestionDTO>> createQuestions(@RequestBody CreateQuestionsDTO createQuestionsDTO) {
        Long workoutPlanId = createQuestionsDTO.getWorkoutPlanId();
        List<QuestionDTO> createdQuestions = questionnaireService.createQuestionsForWorkoutPlan(createQuestionsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestions);
    }

    @GetMapping("/{workoutPlanId}/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestionsForWorkoutPlan(@PathVariable Long workoutPlanId) {
        List<QuestionDTO> questions = questionnaireService.getQuestionsForWorkoutPlan(workoutPlanId);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/submit-answer")
    public ResponseEntity<UserAnswer> submitAnswer(@RequestBody SubmitAnswerDTO submitAnswerDTO) {
        UserAnswer savedAnswer = questionnaireService.submitAnswer(submitAnswerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnswer);
    }

    @PostMapping("/submit-answers")
    public ResponseEntity<List<UserAnswer>> submitBulkAnswers(@RequestBody SubmitBulkAnswersDTO submitBulkAnswersDTO) {
        List<UserAnswer> savedAnswers = questionnaireService.submitBulkAnswers(submitBulkAnswersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnswers);
    }

}

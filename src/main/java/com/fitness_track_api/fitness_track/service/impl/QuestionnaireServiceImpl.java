package com.fitness_track_api.fitness_track.service.impl;

import com.fitness_track_api.fitness_track.controller.dto.request.CreateQuestionsDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.QuestionDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitAnswerDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.SubmitBulkAnswersDTO;
import com.fitness_track_api.fitness_track.exceptions.ResourceNotFoundException;
import com.fitness_track_api.fitness_track.model.Questionnaire;
import com.fitness_track_api.fitness_track.model.User;
import com.fitness_track_api.fitness_track.model.UserAnswer;
import com.fitness_track_api.fitness_track.model.WorkoutPlan;
import com.fitness_track_api.fitness_track.repository.QuestionnaireRepository;
import com.fitness_track_api.fitness_track.repository.UserAnswerRepository;
import com.fitness_track_api.fitness_track.repository.UserRepository;
import com.fitness_track_api.fitness_track.repository.WorkoutPlanRepository;
import com.fitness_track_api.fitness_track.service.QuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private UserRepository userRepository;
    private WorkoutPlanRepository workoutPlanRepository;
    private QuestionnaireRepository questionnaireRepository;
    private UserAnswerRepository userAnswerRepository;

    @Override
    public List<QuestionDTO> createQuestionsForWorkoutPlan(CreateQuestionsDTO createQuestionsDTO) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(createQuestionsDTO.getWorkoutPlanId())
                .orElseThrow(() -> new RuntimeException("Workout plan not found"));

        List<QuestionDTO> createdQuestionsDTO = new ArrayList<>();

        for (String questionText : createQuestionsDTO.getQuestions()) {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setQuestionText(questionText);
            questionnaire.setWorkoutPlan(workoutPlan);
            questionnaireRepository.save(questionnaire);

            createdQuestionsDTO.add(new QuestionDTO(questionnaire.getId(), questionnaire.getQuestionText()));
        }

        return createdQuestionsDTO;
    }

    @Override
    public List<QuestionDTO> getQuestionsForWorkoutPlan(Long workoutPlanId) {
        List<Questionnaire> questionnaires = questionnaireRepository.findByWorkoutPlanId(workoutPlanId);

        if (questionnaires.isEmpty()) {
            throw new ResourceNotFoundException("No questions found for workout plan with ID: " + workoutPlanId);
        }

        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionDTOs.add(new QuestionDTO(questionnaire.getId(), questionnaire.getQuestionText()));
        }

        return questionDTOs;
    }

    @Override
    public UserAnswer submitAnswer(SubmitAnswerDTO submitAnswerDTO) {
        // Find the user
        User user = userRepository.findById(submitAnswerDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the question (questionnaire)
        Questionnaire questionnaire = questionnaireRepository.findById(submitAnswerDTO.getQuestionnaireId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Create the user answer
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setQuestionnaire(questionnaire);
        userAnswer.setAnswer(submitAnswerDTO.getAnswer());

        // Save the answer to the database
        return userAnswerRepository.save(userAnswer);
    }

    @Override
    public List<UserAnswer> submitBulkAnswers(SubmitBulkAnswersDTO submitBulkAnswersDTO) {
        // Find the user
        User user = userRepository.findById(submitBulkAnswersDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // List to hold the saved user answers
        List<UserAnswer> savedAnswers = new ArrayList<>();

        // Loop through each answer in the bulk submission
        for (SubmitBulkAnswersDTO.AnswerDTO answerDTO : submitBulkAnswersDTO.getAnswers()) {
            // Find the question (questionnaire)
            Questionnaire questionnaire = questionnaireRepository.findById(answerDTO.getQuestionnaireId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            // Create a new UserAnswer object and set values
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setUser(user);
            userAnswer.setQuestionnaire(questionnaire);
            userAnswer.setAnswer(answerDTO.getAnswer());

            // Save the answer to the database
            savedAnswers.add(userAnswerRepository.save(userAnswer));
        }

        return savedAnswers;
    }


}

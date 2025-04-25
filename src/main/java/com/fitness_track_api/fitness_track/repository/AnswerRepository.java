//package com.fitness_track_api.fitness_track.repository;
//import com.fitness_track_api.fitness_track.model.Answer;
//import com.fitness_track_api.fitness_track.model.Question;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface AnswerRepository extends JpaRepository<Answer, Long> {
//    List<Answer> findByQuestion(Question question);
//    List<Answer> findByQuestionOrderByCreatedAtAsc(Question question);
//}
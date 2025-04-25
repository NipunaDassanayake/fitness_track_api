package com.fitness_track_api.fitness_track.repository;

import com.fitness_track_api.fitness_track.model.Comment;
import com.fitness_track_api.fitness_track.model.WorkoutPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(WorkoutPost post);
    List<Comment> findByPostOrderByCreatedAtAsc(WorkoutPost post);
}
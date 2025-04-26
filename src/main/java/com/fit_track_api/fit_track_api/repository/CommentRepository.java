package com.fit_track_api.fit_track_api.repository;
import com.fit_track_api.fit_track_api.model.Comment;
import com.fit_track_api.fit_track_api.model.WorkoutPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(WorkoutPost post);
    List<Comment> findByPostOrderByCreatedAtAsc(WorkoutPost post);
}
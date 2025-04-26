<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/repository/CommentRepository.java
package com.fitness_track_api.fitness_track.repository;

import com.fitness_track_api.fitness_track.model.Comment;
import com.fitness_track_api.fitness_track.model.WorkoutPost;
=======
package com.fit_track_api.fit_track_api.repository;
import com.fit_track_api.fit_track_api.model.Comment;
import com.fit_track_api.fit_track_api.model.WorkoutPost;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/repository/CommentRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(WorkoutPost post);
    List<Comment> findByPostOrderByCreatedAtAsc(WorkoutPost post);
}
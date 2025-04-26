<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/repository/WorkoutPostRepository.java
package com.fitness_track_api.fitness_track.repository;
import com.fitness_track_api.fitness_track.model.WorkoutPost;
import com.fitness_track_api.fitness_track.model.User;
=======
package com.fit_track_api.fit_track_api.repository;
import com.fit_track_api.fit_track_api.model.WorkoutPost;
import com.fit_track_api.fit_track_api.model.User;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/repository/WorkoutPostRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkoutPostRepository extends JpaRepository<WorkoutPost, Long> {
    List<WorkoutPost> findByUser(User user);
    List<WorkoutPost> findByUserInOrderByCreatedAtDesc(List<User> users);
    List<WorkoutPost> findAllByOrderByCreatedAtDesc();

    List<WorkoutPost> findByUserId(Long userId);
}

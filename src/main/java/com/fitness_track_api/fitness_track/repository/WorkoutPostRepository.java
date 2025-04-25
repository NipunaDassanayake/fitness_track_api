package com.fitness_track_api.fitness_track.repository;
import com.fitness_track_api.fitness_track.model.WorkoutPost;
import com.fitness_track_api.fitness_track.model.User;
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

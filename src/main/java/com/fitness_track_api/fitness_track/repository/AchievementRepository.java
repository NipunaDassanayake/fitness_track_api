package com.fitness_track_api.fitness_track.repository;
import com.fitness_track_api.fitness_track.model.Achievement;
import com.fitness_track_api.fitness_track.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByUser(User user);
    List<Achievement> findByUserOrderByAchievedDateDesc(User user);
}
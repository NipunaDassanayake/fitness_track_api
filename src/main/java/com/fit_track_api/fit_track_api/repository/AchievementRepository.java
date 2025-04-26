<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/repository/AchievementRepository.java
package com.fitness_track_api.fitness_track.repository;
import com.fitness_track_api.fitness_track.model.Achievement;
import com.fitness_track_api.fitness_track.model.User;
=======
package com.fit_track_api.fit_track_api.repository;
import com.fit_track_api.fit_track_api.model.Achievement;
import com.fit_track_api.fit_track_api.model.User;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/repository/AchievementRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByUser(User user);
    List<Achievement> findByUserOrderByAchievedDateDesc(User user);
}
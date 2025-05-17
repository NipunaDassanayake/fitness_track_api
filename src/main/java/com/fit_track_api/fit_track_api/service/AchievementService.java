<<<<<<< HEAD:src/main/java/com/fit_track_api/fit_track_api/service/AchievementService.java
<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/service/AchievementService.java
package com.fitness_track_api.fitness_track.service;

import com.fitness_track_api.fitness_track.controller.dto.request.CreateAchievementDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.UpdateAchievementDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.AchievementResponseDTO;
import com.fitness_track_api.fitness_track.model.Achievement;
=======
package com.fit_track_api.fit_track_api.service;

=======
package com.fit_track_api.fit_track_api.service;

>>>>>>> origin/shakya:src/main/java/com/fitness_track_api/fitness_track/service/AchievementService.java
import com.fit_track_api.fit_track_api.controller.dto.request.CreateAchievementDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdateAchievementDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.AchievementResponseDTO;
import com.fit_track_api.fit_track_api.model.Achievement;
<<<<<<< HEAD:src/main/java/com/fit_track_api/fit_track_api/service/AchievementService.java
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/service/AchievementService.java
=======
>>>>>>> origin/shakya:src/main/java/com/fitness_track_api/fitness_track/service/AchievementService.java

import java.util.List;

public interface AchievementService {
    public Achievement shareAchievement(Long userId, Long workoutPlanId, CreateAchievementDTO createAchievementDTO);
    public Achievement updateAchievement(Long achievementId, UpdateAchievementDTO updateAchievementDTO);
    public void deleteAchievement(Long userId, Long achievementId);
    public AchievementResponseDTO getAchievementById(Long achievementId);
    public void likeAchievement(Long achievementId, Long userId);
    public void unlikeAchievement(Long achievementId, Long userId);
    public List<AchievementResponseDTO> getAllAchievements();
}


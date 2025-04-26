<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/service/AchievementService.java
package com.fitness_track_api.fitness_track.service;

import com.fitness_track_api.fitness_track.controller.dto.request.CreateAchievementDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.UpdateAchievementDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.AchievementResponseDTO;
import com.fitness_track_api.fitness_track.model.Achievement;
=======
package com.fit_track_api.fit_track_api.service;

import com.fit_track_api.fit_track_api.controller.dto.request.CreateAchievementDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdateAchievementDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.AchievementResponseDTO;
import com.fit_track_api.fit_track_api.model.Achievement;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/service/AchievementService.java

import java.util.List;

public interface AchievementService {
    public Achievement shareAchievement(Long userId, Long workoutPlanId, CreateAchievementDTO createAchievementDTO);
    public Achievement updateAchievement(Long achievementId, UpdateAchievementDTO updateAchievementDTO);
    public void deleteAchievement(Long userId, Long achievementId);
    public AchievementResponseDTO getAchievementById(Long achievementId);
}


// AchievementController.java
package com.fit_track_api.fit_track_api.controller;

import com.fit_track_api.fit_track_api.controller.dto.request.CreateAchievementDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdateAchievementDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.AchievementResponseDTO;
import com.fit_track_api.fit_track_api.model.Achievement;
import com.fit_track_api.fit_track_api.service.AchievementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    @PostMapping(value = "/share-achievement/{workoutPlanId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> shareAsAchievement(
            @RequestParam Long userId,
            @PathVariable Long workoutPlanId,
            @ModelAttribute CreateAchievementDTO createAchievementDTO) {
        try {
            Achievement achievement = achievementService.shareAchievement(userId, workoutPlanId, createAchievementDTO);
            return ResponseEntity.ok("User shared an achievement");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    @PutMapping("/{achievementId}")
    public ResponseEntity<String> updateAchievement(
            @PathVariable Long achievementId,
            @ModelAttribute UpdateAchievementDTO updateAchievementDTO) {
        Achievement updatedAchievement = achievementService.updateAchievement(achievementId, updateAchievementDTO);
        return ResponseEntity.ok("Achievement updated successfully ");
    }

    @DeleteMapping("/users/{userId}/achievements/{achievementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserAchievement(
            @PathVariable Long userId,
            @PathVariable Long achievementId) {
        achievementService.deleteAchievement(userId, achievementId);
    }

    @GetMapping("/{achievementId}")
    public ResponseEntity<AchievementResponseDTO> getAchievementById(
            @PathVariable Long achievementId) {
        AchievementResponseDTO achievement = achievementService.getAchievementById(achievementId);
        return ResponseEntity.ok(achievement);
    }



}

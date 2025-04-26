<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/service/WorkoutPostService.java
package com.fitness_track_api.fitness_track.service;

import com.fitness_track_api.fitness_track.controller.dto.request.CreatePostRequestDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.UpdatePostRequestDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.GetPostByIdResponseDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.GetPostByUserResponseDTO;
import com.fitness_track_api.fitness_track.model.User;
import com.fitness_track_api.fitness_track.model.WorkoutPost;
=======
package com.fit_track_api.fit_track_api.service;

import com.fit_track_api.fit_track_api.controller.dto.request.CreatePostRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdatePostRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetPostByIdResponseDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetPostByUserResponseDTO;
import com.fit_track_api.fit_track_api.model.User;
import com.fit_track_api.fit_track_api.model.WorkoutPost;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/service/WorkoutPostService.java

import java.util.List;

public interface WorkoutPostService {
    WorkoutPost createPost(CreatePostRequestDTO createPostRequestDTO, Long userId);
    void updatePost(Long id, UpdatePostRequestDTO updatePostRequestDTO);
    void deletePost(Long id);
    GetPostByIdResponseDTO getPostById(Long id);
    List<GetPostByUserResponseDTO> getPostsByUser(Long userId);
    List<WorkoutPost> getFeedPosts(User user);
    List<WorkoutPost> getAllPosts();
    void likePost(Long postId, Long userId);
    void unlikePost(Long postId, Long userId);
    boolean isPostLikedByUser(Long postId, Long userId);
}

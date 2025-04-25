package com.fitness_track_api.fitness_track.service;

import com.fitness_track_api.fitness_track.controller.dto.request.CreatePostRequestDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.UpdatePostRequestDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.GetPostByIdResponseDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.GetPostByUserResponseDTO;
import com.fitness_track_api.fitness_track.model.User;
import com.fitness_track_api.fitness_track.model.WorkoutPost;

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

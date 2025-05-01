package com.fit_track_api.fit_track_api.service.impl;

import com.cloudinary.Cloudinary;
import com.fit_track_api.fit_track_api.controller.dto.request.CreatePostRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.request.UpdatePostRequestDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetPostByIdResponseDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetPostByUserResponseDTO;
import com.fit_track_api.fit_track_api.controller.dto.response.GetUserByIdResponseDTO;
import com.fit_track_api.fit_track_api.exceptions.ResourceNotFoundException;
import com.fit_track_api.fit_track_api.model.User;
import com.fit_track_api.fit_track_api.model.WorkoutPost;
import com.fit_track_api.fit_track_api.repository.UserRepository;
import com.fit_track_api.fit_track_api.repository.WorkoutPostRepository;
import com.fit_track_api.fit_track_api.service.WorkoutPostService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class WorkoutPostServiceImpl implements WorkoutPostService {

    private final WorkoutPostRepository workoutPostRepository;
    private final UserRepository userRepository;
    private final Cloudinary cloudinary;



    @Override
    public WorkoutPost createPost(CreatePostRequestDTO createPostRequestDTO, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<String> imageUrls = new ArrayList<>();
        if (createPostRequestDTO.getImageUrls() != null && !createPostRequestDTO.getImageUrls().isEmpty()) {
            for (MultipartFile image : createPostRequestDTO.getImageUrls()) {
                try {
                    String imageUrl = cloudinary.uploader()
                            .upload(image.getBytes(), Map.of(
                                    "public_id", UUID.randomUUID().toString(),
                                    "folder", "WorkoutPosts"
                            ))
                            .get("url")
                            .toString();
                    imageUrls.add(imageUrl);
                } catch (Exception e) {
                    throw new RuntimeException("Image upload failed", e);
                }
            }
        }

        WorkoutPost post = new WorkoutPost();
        post.setDescription(createPostRequestDTO.getDescription());
        post.setTitle(createPostRequestDTO.getTitle());
        post.setImageUrl(imageUrls);
        post.setUser(user);
        return workoutPostRepository.save(post);
    }

    @Override
    public void updatePost(Long id, UpdatePostRequestDTO updatePostRequestDTO) {
        try {
            WorkoutPost post =workoutPostRepository.findById(id).orElseThrow(()->new RuntimeException("Workut post not found"));

            if (updatePostRequestDTO.getDescription() != null) {
                post.setDescription(updatePostRequestDTO.getDescription());
            }
            if (updatePostRequestDTO.getTitle() != null) {
                post.setTitle(updatePostRequestDTO.getTitle());
            }
            if (updatePostRequestDTO.getImageUrls() != null && !updatePostRequestDTO.getImageUrls().isEmpty()) {
                List<String> uploadedImageUrls = new ArrayList<>();

                for (MultipartFile image : updatePostRequestDTO.getImageUrls()) {
                    String imageUrl = cloudinary.uploader()
                            .upload(image.getBytes(), Map.of(
                                    "public_id", UUID.randomUUID().toString(),
                                    "folder", "WorkoutPosts"))
                            .get("url")
                            .toString();

                    uploadedImageUrls.add(imageUrl);
                }
                post.setImageUrl(uploadedImageUrls);
            }
            workoutPostRepository.save(post);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update post with ID: " + id, e);
        }


    }

}

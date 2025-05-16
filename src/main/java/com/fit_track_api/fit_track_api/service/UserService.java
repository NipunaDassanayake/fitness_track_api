package com.fit_track_api.fit_track_api.service;

import com.fit_track_api.fit_track_api.model.User;
import com.fitness_track_api.fitness_track.controller.dto.request.CreateUserRequestDTO;
import com.fitness_track_api.fitness_track.controller.dto.request.UserUpdateRequestDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.GetAllUsersResponseDTO;
import com.fitness_track_api.fitness_track.controller.dto.response.GetUserByIdResponseDTO;
import com.fitness_track_api.fitness_track.model.User;

import java.util.List;

public interface UserService {
    User registerUser(CreateUserRequestDTO createUserRequestDTO);
    User updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO);
    void deleteUser(Long id);
    public User loginUserLocal(LoginRequestDTO loginRequestDTO);
    public User loginRegisterByGoogleOAuth2(OAuth2AuthenticationToken auth2AuthenticationToken);
    public GetUserByIdResponseDTO getUserById(Long id);
    public List<GetAllUsersResponseDTO> getAllUsers();
    void followUser(Long followerId, Long followedId);
    void unfollowUser(Long followerId, Long followedId);
    public List<GetAllUsersResponseDTO> getFollowing(Long userId) ;
    public List<GetAllUsersResponseDTO> getFollowers(Long userId);
}

package com.example.demo.service;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    Long getSummaryPrice(Long userId);

    UserDTO createUser(UserDTO userDTO);

    UserDTO addGameToUser(Long userId, Long gameId);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUserById(Long id);


}
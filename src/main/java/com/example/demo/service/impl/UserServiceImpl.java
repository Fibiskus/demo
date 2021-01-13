package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import com.example.demo.mapper.GameToGameDTOMapper;
import com.example.demo.mapper.UserToUserDTOMapper;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserToUserDTOMapper userMapper;
    @Autowired
    private GameToGameDTOMapper gameMapper;
    @Override
    public UserDTO getUserById(final Long id) {
        return userMapper.toDto(userRepository.getUserById(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(e -> userMapper.toDto(e))
                .collect(Collectors.toList());
    }
    @Override
    public Long getSummaryPrice(final Long userId){
        if(userId == null){
            throw new FormatException("User should have an id ", HTTP.HTTP_400);
        }
    return userRepository.getSummaryPrice(userRepository.getUserById(userId));
    }
    @Override
    public UserDTO createUser(final UserDTO userDTO) {

        if(userDTO.getId() != null){
            throw new FormatException("User shouldn't have an id ", HTTP.HTTP_400);
        }

        return userMapper.toDto(userRepository.createUser(userMapper.toEntity(userDTO)));
    }
    @Override
    public UserDTO addGameToUser(final Long userId, final Long gameId) {

        if(userId == null){
            throw new FormatException("User should have an id ", HTTP.HTTP_400);
        }
        if(gameId == null){
            throw new FormatException("Game should have an id ", HTTP.HTTP_400);
        }
        return userMapper.toDto(userRepository.addGameToUser(userRepository.getUserById(userId),gameRepository.getGameById(gameId)));
    }
    @Override
    public UserDTO updateUser(final UserDTO userDTO) {

        if(userDTO.getId() == null){
            throw new FormatException("User have an id ", HTTP.HTTP_400);
        }

        return userMapper.toDto(userRepository.updateUser(userMapper.toEntity(userDTO)));
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteUserById(id);
    }
}
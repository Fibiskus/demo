package com.example.demo.mapper;


import com.example.demo.dto.GameDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDTOMapper {
    @Autowired
    private GameToGameDTOMapper gameToGameDTOMapper;

    public User toEntity(final UserDTO userDTO) {
        final User user = new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        if (userDTO.getGames() == null) {
            user.setGames(null);
        } else {
            final List<Game> gameList = new ArrayList<>();
            for (final GameDTO gameDTO : userDTO.getGames()) {
                gameList.add(gameToGameDTOMapper.toEntity(gameDTO));
            }
            user.setGames(gameList);
        }

        return user;
    }

    public UserDTO toDto(final User user) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        if (user.getGames() == null) {
            userDTO.setGames(null);
        } else {
            final List<GameDTO> gameDTOList = new ArrayList<>();
            for (final Game game : user.getGames()) {
                gameDTOList.add(gameToGameDTOMapper.toDto(game));
            }
            userDTO.setGames(gameDTOList);
        }

        return userDTO;
    }
}
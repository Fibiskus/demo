package com.example.demo.service.impl;

import com.example.demo.dto.GameDTO;
import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import com.example.demo.mapper.GameToGameDTOMapper;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameToGameDTOMapper gameMapper;

    @Override

    public GameDTO getGameById(final Long id) {
        return gameMapper.toDto(gameRepository.getGameById(id));
    }

    @Override
    public List<GameDTO> getAllGames() {
        return gameRepository.getAllGames().stream()
                .map(e -> gameMapper.toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public Long getCost(final Long gameId) {
        return gameRepository.getCost(gameRepository.getGameById(gameId));
    }

    @Override
    public GameDTO createGame(final GameDTO gameDTO) {

        if (gameDTO.getId() != null) {
            throw new FormatException("Game shouldn't have an id ", HTTP.HTTP_400);
        }

        return gameMapper.toDto(gameRepository.createGame(gameMapper.toEntity(gameDTO)));
    }

    @Override
    public GameDTO updateGame(final GameDTO gameDTO) {

        if (gameDTO.getId() == null) {
            throw new FormatException("Game should have an id ", HTTP.HTTP_400);
        }

        return gameMapper.toDto(gameRepository.updateGame(gameMapper.toEntity(gameDTO)));
    }

    @Override
    public void deleteGameById(final Long id) {
        gameRepository.deleteGameById(id);
    }
}
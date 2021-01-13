package com.example.demo.service;

import com.example.demo.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO getGameById(Long id);
    List<GameDTO> getAllGames();
    Long getCost(Long gameId);
    GameDTO createGame(GameDTO gameDTO);
    GameDTO updateGame(GameDTO gameDTO);
    void deleteGameById(Long id);


}
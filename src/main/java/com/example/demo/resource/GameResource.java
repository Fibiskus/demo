package com.example.demo.resource;

import com.example.demo.dto.GameDTO;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameResource {
    @Autowired
    private GameService gameService;

    @GetMapping("/games/{id}")
    public GameDTO getGameById(final @PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/games")
    public List<GameDTO> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games-cost/{gameId}")
    public String getCost(final @PathVariable Long gameId) {
        return "The summary cost of game with id " + gameId
                + " and dlcs is " + gameService.getCost(gameId);
    }

    @PostMapping("/games")
    public GameDTO createGame(final @Valid @RequestBody GameDTO gameDTO) {
        return gameService.createGame(gameDTO);
    }

    @PutMapping("/games")
    public GameDTO updateGame(final @Valid @RequestBody GameDTO gameDTO) {
        return gameService.updateGame(gameDTO);
    }

    @DeleteMapping("/games/{id}")
    public void deleteGameById(final @PathVariable Long id) {
        gameService.deleteGameById(id);
    }
}

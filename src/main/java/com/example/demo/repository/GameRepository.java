package com.example.demo.repository;

import com.example.demo.DataBase;
import com.example.demo.entity.DLC;
import com.example.demo.entity.Game;
import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameRepository {

    @PostConstruct
    public void init() {
        savedGames = new ArrayList<>();
        savedGames.add(DataBase.game1);
        savedGames.add(DataBase.game2);
        savedGames.add(DataBase.game3);

    }

    private static Long lastId = 4L;
    private List<Game> savedGames;

    public Game getGameById(final Long id) {
        return savedGames.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FormatException("Game with id: " + id + " not found ", HTTP.HTTP_400));
    }

    public List<Game> getAllGames() {
        return savedGames;
    }

    public Long getCost(final Game game) {
        if (game.getDlcs() == null) {
            return 0L;
        } else {
            return (game.getPrice() + game.getDlcs().stream().map(DLC::getCost).reduce(Long::sum).orElse(0L));
        }
    }

    public Game createGame(final Game game) {
        if (game.getId() != null) {
            throw new FormatException("Game shouldn't have an id ", HTTP.HTTP_400);
        }

        ++lastId;
        game.setId(lastId);

        savedGames.add(game);

        return game;
    }

    public Game updateGame(final Game game) {
        if (game.getId() == null) {
            throw new FormatException("Game should have an id ", HTTP.HTTP_400);
        }

        final Game savedGame = getGameById(game.getId());

        savedGame.setName(game.getName());
        savedGame.setDescription(game.getDescription());
        savedGame.setPrice(game.getPrice());
        savedGame.setDlcs(game.getDlcs());


        return savedGame;
    }

    public void deleteGameById(final Long id) {
        if (id == null) {
            throw new FormatException("Id isn't specified", HTTP.HTTP_400);
        }

        savedGames.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FormatException("Game with id: " + id + " not found ", HTTP.HTTP_400));

        savedGames = savedGames.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }

}
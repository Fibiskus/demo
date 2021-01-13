package com.example.demo.mapper;


import com.example.demo.dto.DLCDTO;
import com.example.demo.dto.GameDTO;
import com.example.demo.entity.DLC;
import com.example.demo.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameToGameDTOMapper {
    @Autowired
    private DLCToDLCDTOMapper dlcToDLCDTOMapper;

    public Game toEntity(final GameDTO gameDTO) {
        final Game game = new Game();

        game.setId(gameDTO.getId());
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPrice(gameDTO.getPrice());
        if (gameDTO.getDlcs() == null) {
            game.setDlcs(null);
        } else {
            final List<DLC> dlcList = new ArrayList<>();
            for (final DLCDTO dlcDTO : gameDTO.getDlcs()) {
                dlcList.add(dlcToDLCDTOMapper.toEntity(dlcDTO));
            }
            game.setDlcs(dlcList);
        }
        return game;
    }

    public GameDTO toDto(final Game game) {
        final GameDTO gameDTO = new GameDTO();

        gameDTO.setId(game.getId());
        gameDTO.setName(game.getName());
        gameDTO.setDescription(game.getDescription());
        gameDTO.setPrice(game.getPrice());
        if (game.getDlcs() == null) {
            gameDTO.setDlcs(null);
        } else {
            final List<DLCDTO> dlcDTOList = new ArrayList<>();
            for (final DLC dlc : game.getDlcs()) {
                dlcDTOList.add(dlcToDLCDTOMapper.toDto(dlc));
            }
            gameDTO.setDlcs(dlcDTOList);
        }
        return gameDTO;

    }
}

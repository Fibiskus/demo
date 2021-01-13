package com.example.demo.repository;

import com.example.demo.DataBase;
import com.example.demo.entity.DLC;
import com.example.demo.entity.Game;
import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DLCRepository {

    @PostConstruct
    public void init() {
        savedDLC = new ArrayList<>();
        savedDLC.addAll(DataBase.game1.getDlcs());
        savedDLC.addAll(DataBase.game2.getDlcs());
        savedDLC.addAll(DataBase.game3.getDlcs());

    }

    private static Long lastId = 9L;
    private List<DLC> savedDLC;

    public DLC getDLCById(final Long id) {
        return savedDLC.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FormatException("DLC with id: " + id + " not found ", HTTP.HTTP_400));
    }

    public List<DLC> getAllDLCs() {
        return savedDLC;
    }


    public DLC createDLC(final DLC dlc, final Game game) {
        if (dlc.getId() != null) {
            throw new FormatException("DLC shouldn't have an id ", HTTP.HTTP_400);
        }
        if (game.getId() == null) {
            throw new FormatException("Game should have an id ", HTTP.HTTP_400);
        }
        ++lastId;
        dlc.setId(lastId);

        savedDLC.add(dlc);
        if (game.getDlcs() != null) {
            game.getDlcs().add(dlc);
        } else {
            game.setDlcs(new ArrayList<>(Collections.singletonList(dlc)));
        }
        return dlc;
    }

    public DLC updateDLC(final DLC dlc) {
        if (dlc.getId() == null) {
            throw new FormatException("DLC should have an id ", HTTP.HTTP_400);
        }

        final DLC savedDLC = getDLCById(dlc.getId());

        savedDLC.setName(dlc.getName());
        savedDLC.setDescription(dlc.getDescription());
        savedDLC.setCost(dlc.getCost());


        return savedDLC;
    }

    public void deleteDLCById(final Long id) {
        if (id == null) {
            throw new FormatException("Id isn't specified", HTTP.HTTP_400);
        }

        savedDLC.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FormatException("DLC with id: " + id + " not found ", HTTP.HTTP_400));

        savedDLC = savedDLC.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }

}
package com.example.demo;

import com.example.demo.entity.DLC;
import com.example.demo.entity.Game;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
   public static Map<Long, Game> map = new HashMap<>();
    public static Game game1 = new Game(2L, "Vitaliny", "Adventures of young and innocent school boy Vitaliny.", 1000, new ArrayList<>());

    static {
        game1.getDlcs().add(new DLC(1L, "Vitaliny on the beach", "School trip and unforgettable memories for Vitaliny.", 500));
        game1.getDlcs().add(new DLC(2L, "Vitaliny on the forest", "Little red Vitaliny and big grey wolves.", 1000));
        game1.getDlcs().add(new DLC(3L, "Vitaliny on the garden", "Who would know that the most beautiful flower in the garden is Vitaliny?", 1500));
        map.put(game1.getId(), game1);
    }

    public static Game game2 = new Game(3L, "Vitaliusa", "Adventures of young princess Vitaliusa.", 500, new ArrayList<>());

    static {
        game2.getDlcs().add(new DLC(4L, "Protection", "The handsome knight Rederico rescues the cute princess.", 800));
        game2.getDlcs().add(new DLC(5L, "Wedding", "Black dragon boy Ricardo steals the princess Vitaliusa and ruins her wedding.", 1600));
        game2.getDlcs().add(new DLC(6L, "Hole", "Sword fight with knight Rederico and dragon Ricardo.", 2400));
        map.put(game2.getId(), game2);
    }

    public static Game game3 = new Game(4L, "Boku no Vital", "Vital meets Tamotsu and they have fun with ice cream in the car.", 400, new ArrayList<>());

    static {
        game3.getDlcs().add(new DLC(7L, "Chical", "Brunet boy who lives with his older sister finds Vital under their door.", 700));
        game3.getDlcs().add(new DLC(8L, "Cocal", "Cocal is feminine-looking boy with long, black hair who Vital and Chical meet in the pool.", 1400));
        game3.getDlcs().add(new DLC(9L, "Greccal", "Tall old man Greccal falls in love with Vital who is wearing maid costume on the roof.", 2100));
        map.put(game3.getId(), game3);
    }

    static Map<String, User> users = new HashMap<String, User>();

}
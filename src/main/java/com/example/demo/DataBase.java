package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    static Map<Integer, Game> map = new HashMap<Integer, Game>();
    static Game game1 = new Game("Vitaliny", "Adventures of young and innocent school boy Vitaliny.", 1, 1000);
    static {
        game1.getDlcs().put(1, new DLC("Vitaliny on the beach","School trip and unforgettable memories for Vitaliny.", 500));
        game1.getDlcs().put(2, new DLC("Vitaliny on the forest","Little red Vitaliny and big grey wolves.", 1000));
        game1.getDlcs().put(3, new DLC("Vitaliny on the garden","Who would know that the most beautiful flower in the garden is Vitaliny?", 1500));
        map.put(game1.getID(), game1);
    }
    static Game game2 = new Game("Vitaliusa", "Adventures of young princess Vitaliusa.", 2, 500);
    static {
        game2.getDlcs().put(1, new DLC("Protection","The handsome knight Rederico rescues the cute princess.", 800));
        game2.getDlcs().put(2, new DLC("Wedding","Black dragon boy Ricardo steals the princess Vitaliusa and ruins her wedding.", 1600));
        game2.getDlcs().put(3, new DLC("Hole","Sword fight with knight Rederico and dragon Ricardo.", 2400));
        map.put(game2.getID(), game2);
    }
    static Game game3 = new Game("Boku no Vital", "Vital meets Tamotsu and they have fun with ice cream in the car.", 3, 400);
    static {
        game3.getDlcs().put(1, new DLC("Chical","Brunet boy who lives with his older sister finds Vital under their door.", 700));
        game3.getDlcs().put(2, new DLC("Cocal","Cocal is feminine-looking boy with long, black hair who Vital and Chical meet in the pool.", 1400));
        game3.getDlcs().put(3, new DLC("Greccal","Tall old man Greccal falls in love with Vital who is wearing maid costume on the roof.", 2100));
        map.put(game3.getID(), game3);
    }
    static Map<String, User> users = new HashMap<String, User>();

}
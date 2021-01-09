package com.example.demo;

import java.util.HashMap;
import java.util.Map;


public class Game {

    private final String name;
    private final String description;
    private final int iD;
    private final long price;
    Map<Integer, DLC> dlcs = new HashMap<Integer, DLC>();

    public Game(final String name, final String description, final int iD, final long price) {
        this.name = name;
        this.description = description;
        this.iD = iD;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return iD;
    }
    public long getPrice() {
        return price;
    }

    public Map<Integer, DLC> getDlcs() {
        return dlcs;
    }

}
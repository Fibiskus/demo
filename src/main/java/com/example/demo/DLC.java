package com.example.demo;

public class DLC {

    private final String name;
    private final String description;
    private final long cost;


    public DLC(final String name, final String description, final long cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;

    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public long getCost() {
        return cost;
    }



}
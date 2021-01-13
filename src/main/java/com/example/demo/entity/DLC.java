package com.example.demo.entity;

public class DLC {

    private Long id;
    private String name;
    private String description;
    private long cost;

    public DLC() {
    }

    public DLC(final Long id, final String name, final String description, final long cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(final long cost) {
        this.cost = cost;
    }
}
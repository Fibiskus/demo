package com.example.demo.entity;

import java.util.List;


public class Game {

    private Long id;
    private String name;
    private String description;
    private long price;
    private List<DLC> dlcs;

    public Game() {
    }

    public Game(final Long id, final String name, final String description, final long price, final List<DLC> dlcs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dlcs = dlcs;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public List<DLC> getDlcs() {
        return dlcs;
    }

    public void setDlcs(final List<DLC> dlcs) {
        this.dlcs = dlcs;
    }
}
package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DLCDTO {
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 80)
    private String name;
    @NotNull
    @Size(max = 500)
    private String description;
    @NotNull
    @Min(0)
    private long cost;

    public DLCDTO() {
    }

    public DLCDTO(final Long id, final String name, final String description, final long cost) {
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

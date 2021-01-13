package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class GameDTO {
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
    private long price;
    private List<DLCDTO> dlcs;

    public GameDTO() {
    }

    public GameDTO(final Long id, final String name, final String description, final long price, final List<DLCDTO> dlcs) {
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

    public List<DLCDTO> getDlcs() {
        return dlcs;
    }

    public void setDlcs(final List<DLCDTO> dlcs) {
        this.dlcs = dlcs;
    }
}

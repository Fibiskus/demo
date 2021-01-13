package com.example.demo.dto;

import javax.validation.constraints.*;
import java.util.List;

public class UserDTO {
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String firstName;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String lastName;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Min(18)
    @Max(130)
    private int age;
    private List<GameDTO> games;

    public UserDTO() {
    }

    public UserDTO(final Long id, final String firstName, final String lastName, final String email, final int age, final List<GameDTO> games) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(final List<GameDTO> games) {
        this.games = games;
    }
}

package com.example.demo.repository;

import com.example.demo.entity.Game;
import com.example.demo.entity.User;
import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    @Autowired
    public GameRepository gameRepository;

    @PostConstruct
    public void init() {
        savedUsers = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<User> savedUsers;

    public User getUserById(final Long id) {
        return savedUsers.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new FormatException("User with id: " + id + " not found ", HTTP.HTTP_400));
    }

    public List<User> getAllUsers() {
        return savedUsers;
    }

    public Long getSummaryPrice(final User user) {
        if (user.getGames() == null) {
            return 0L;
        } else {
            return user.getGames().stream().map(g -> gameRepository.getCost(g)).reduce(Long::sum).orElse(0L);
        }
    }
        public User createUser ( final User user){
            if (user.getId() != null) {
                throw new FormatException("User shouldn't have an id ", HTTP.HTTP_400);
            }

            ++lastId;
            user.setId(lastId);

            savedUsers.add(user);

            return user;
        }

        public User addGameToUser ( final User user, final Game game){
            if (user.getGames() != null) {
                if (user.getGames().stream().filter(g -> g.getId().equals(game.getId())).findFirst().orElse(null) != null) {
                    throw new FormatException("User already have this game ", HTTP.HTTP_400);
                }
            }
            if (user.getGames() != null) {
                user.getGames().add(game);
            } else {
                user.setGames(new ArrayList<>(Collections.singletonList(game)));
            }
            updateUser(user);
            return user;
        }

        public User updateUser ( final User user){
            if (user.getId() == null) {
                throw new FormatException("User should have an id ", HTTP.HTTP_400);
            }

            final User savedUser = getUserById(user.getId());

            savedUser.setGames(user.getGames());
            savedUser.setAge(user.getAge());
            savedUser.setLastName(user.getLastName());
            savedUser.setFirstName(user.getFirstName());
            savedUser.setEmail(user.getEmail());


            return savedUser;
        }

        public void deleteUserById ( final Long id){
            if (id == null) {
                throw new FormatException("Id isn't specified", HTTP.HTTP_400);
            }

            savedUsers.stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new FormatException("User with id: " + id + " not found ", HTTP.HTTP_400));

            savedUsers = savedUsers.stream()
                    .filter(e -> !e.getId().equals(id))
                    .collect(Collectors.toList());

        }

    }
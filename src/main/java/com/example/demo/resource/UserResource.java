package com.example.demo.resource;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO getUserById(final @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/users-price/{userId}")
    public String getSummaryPrice( final @PathVariable Long userId){
        return "The summary cost of all games of user with id " + userId
                + " is " + userService.getSummaryPrice(userId);
    }
    @PostMapping("/users")
    public UserDTO createUser(final @Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PostMapping("/users/{userId}/{gameId}")
    public UserDTO addGameToUser(final @PathVariable Long userId, final @PathVariable Long gameId) {
        return userService.addGameToUser(userId, gameId);
    }

    @PutMapping("/users")
    public UserDTO updateUser(final @Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(final @PathVariable Long id) {
        userService.deleteUserById(id);
    }
}

package com.example.demo;

import com.example.demo.exception.FormatException;
import com.example.demo.exception.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Min;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@Validated
public class EndPoints {

    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/get_about_game")
    @ResponseBody
    public Game getGameInfo(@RequestParam(name="game_id", required=true) @Min(1) final int id) {
        return DataBase.map.get(id);
    }



    @GetMapping("/get_all_games")
    @ResponseBody
    public Map<Integer, Game> getAllGames() {
        return DataBase.map;
    }



    @GetMapping("/get_price")
    @ResponseBody
    public String getPrice(
            @RequestParam(name="game_id", required=true) @Min(1) final int id,
            @RequestParam(name="dlc_name", required=true) final String dlcName
    ) {
        final Game game = DataBase.map.get(id);
        return "The summary cost of " + game.getName()
                + " game and " + game.getDlcs().get(id).getName()
                + " DLC is " + (game.getPrice()+ game.getDlcs().get(id).getCost());
    }


    @GetMapping("/add_user")
    @ResponseBody
    public String addUser(
            @RequestParam(name="first_name", required=true) final String firstName,
            @RequestParam(name="last_name", required=true) final String lastName,
            @RequestParam(name="age", required=true) @Min(1) final int age,
            @RequestParam(name="email", required=true) final String email
    ) {
        DataBase.users.put(email, new User(firstName, lastName, email, age));
        return "User is created";
    }



    @GetMapping("/get_all_users")
    @ResponseBody
    public Map<String,User> getAllUsers() {
        return DataBase.users;
    }



    @GetMapping("/remove_user")
    @ResponseBody
    public String removeUser(@RequestParam(name="email", required=true) final String email) {
        if (!DataBase.users.containsKey(email)) {
            throw new FormatException("No such user", HTTP.HTTP_400);
        }
        DataBase.users.remove(email);
        return "User is removed";
    }

}
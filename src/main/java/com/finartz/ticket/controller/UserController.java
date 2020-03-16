package com.finartz.ticket.controller;

import com.finartz.ticket.model.User;
import com.finartz.ticket.model.UserId;
import com.finartz.ticket.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by promegalex on 11.03.2020 18:33
 */
@RestController
@RequestMapping(value = {"/user"}, produces = "application/json;charset=UTF-8")
@Api(value = "User Controller Api")
public class UserController extends AbstractController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getUsers() {
        List<User> users = userService.getAll();
        return createResponse(users, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getUser(@RequestParam String name, @RequestParam String surname, @RequestParam String personalId) {
        UserId userId = new UserId(name, surname, personalId);
        Optional<User> user = userService.get(userId);
        return createResponse(user.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        userService.save(user);
        return createResponse("Airline Company successfully registered", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        userService.update(user);
        return createResponse("Airline Company successfully updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteUser(@RequestParam String name, @RequestParam String surname, @RequestParam String personalId) {
        UserId userId = new UserId(name, surname, personalId);
        userService.delete(userId);
        return createResponse("Airline Company successfully deleted", HttpStatus.OK);
    }
}

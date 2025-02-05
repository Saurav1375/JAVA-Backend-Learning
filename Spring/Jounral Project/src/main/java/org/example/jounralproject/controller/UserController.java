package org.example.jounralproject.controller;

import org.bson.types.ObjectId;
import org.example.jounralproject.model.User;
import org.example.jounralproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{userName}")
    public User getUserByUserName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }

    @GetMapping("{userId}")
    public User getUserByUserId(@PathVariable ObjectId userId) {
        return userService.getUserById(userId).orElse(null);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
        User userFromDB = userService.getUserByUserName(userName);
        if (userFromDB != null) {
            userFromDB.setUserName(userName);
            userFromDB.setPassword(user.getPassword());
            userService.saveUser(userFromDB);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
    }


}

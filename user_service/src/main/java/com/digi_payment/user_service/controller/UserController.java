package com.digi_payment.user_service.controller;

import com.digi_payment.user_service.Entity.User;
import com.digi_payment.user_service.exception.UserNotFoundException;
import com.digi_payment.user_service.repository.UserRepository;
import com.digi_payment.user_service.service.UserService;
import com.digi_payment.user_service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/test")
    public String test() {
        return "Working";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userServiceImpl.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userServiceImpl.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userServiceImpl.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

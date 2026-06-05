package com.localservicefinder.servicefinder.controller;

import com.localservicefinder.servicefinder.entity.User;
import com.localservicefinder.servicefinder.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userRepository.save(user);

    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {

        return userRepository.findByEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        );

    }
    @GetMapping("/all")
public List<User> getAllUsers(){

    return userRepository.findAll();

}
@DeleteMapping("/{id}")
public String deleteUser(
        @PathVariable Long id){

    userRepository.deleteById(id);

    return "User Deleted";

}
}
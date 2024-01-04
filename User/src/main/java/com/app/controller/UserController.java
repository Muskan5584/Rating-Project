package com.app.controller;

import com.app.Entity.Rating;
import com.app.Entity.User;
import com.app.Repository.UserRepo;
import com.app.ServiceImpl.UserServiceImpl;
import com.app.exception.ResourceNotFound;
import com.app.response.UserResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ModelMapper modelMapper;

    //Create User
    @PostMapping("/save")
    public User save(@RequestBody User user){
       User user1 = userService.save(user);
           return user1;

    }

    //Update User
    @PutMapping("/update/{id}")
    public Object updateUser(@PathVariable String id, @RequestBody User user){
        try {
           return userService.update(user, id);
        }catch(ResourceNotFound resourceNotFound){
            return new ResourceNotFound();
        }
    }

    //delete User
    @DeleteMapping("/delete/{id}")
    public Object deleteUser(@PathVariable String id){
        try {
            return userService.delete(id);
        }catch(ResourceNotFound resourceNotFound){
            return new ResourceNotFound();
        }
    }

    //get User
    @GetMapping("/get/{id}")
    public Object getUser(@PathVariable String id){
        try {
            User user = userService.get(id);
            UserResponseApi userResponseApi = modelMapper.map(user, UserResponseApi.class);
            return userResponseApi;
        }catch(ResourceNotFound resourceNotFound){
            return new ResourceNotFound();
        }
    }

    //getAll Users
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}

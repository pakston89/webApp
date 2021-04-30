package com.webApp.webApp.controller;

import com.webApp.webApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.webApp.webApp.model.User;
import java.util.List;

@RestController
public class UserController {
 
    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }
    @GetMapping("/getUserByIdOut")
    public ResponseEntity<User> getUserOut(@RequestParam String id){
        return userServiceImpl.getUserOut(id);
    }
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam Integer id){
        return userServiceImpl.getUserById(id);
    }
    @GetMapping("/getUserByName")
    public List<User> getUserByName(@RequestParam String name){
        return userServiceImpl.getUserByName(name);
    }
    @PostMapping("/addUserIn")
    public void addUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
    }
    @DeleteMapping("/deleteUserIn")
    public void deleteUser(@RequestParam Integer id) {
        userServiceImpl.deleteUser(id);
    }
    @PutMapping("/updateUserIn")
    public void updateUser(@RequestBody User user) {
        userServiceImpl.updateUser(user);
    }
    @PatchMapping("/updateUserName")
    public void updateUserName(@RequestBody User user) {
        userServiceImpl.updateUserName(user);
    }
}

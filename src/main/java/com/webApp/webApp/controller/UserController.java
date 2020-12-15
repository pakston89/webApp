package com.webApp.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.webApp.webApp.model.User;
import com.webApp.webApp.service.UserService;
import java.util.List;

@RestController
@RequestMapping
public class UserController {
 
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUserByIdOut")
    public ResponseEntity<User> getUserOut(@RequestParam String id){
        return userService.getUserOut(id);
    }

    @GetMapping("/getUserByIdIn")
    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/addUserIn")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/deleteUserIn")
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping("/updateUserIn")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PatchMapping("/updateUserName")
    public void updateUserName(@RequestBody User user) {
        userService.updateUserName(user);
    }
}

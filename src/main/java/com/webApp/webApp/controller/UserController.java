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
    public ResponseEntity<User[]> getUserOut(@RequestParam String userId){
        return userService.getUserOut(userId);
    }

    @GetMapping("getUserByIdIn")
    public User getUser(@RequestParam Integer userId){
        return userService.getUser(userId);
    }

    @PostMapping("addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@RequestParam Integer userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PatchMapping
    public void updateSomethingAboutMyUser(@RequestBody User user) {
        //
    }
}

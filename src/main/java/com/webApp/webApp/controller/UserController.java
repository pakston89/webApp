package com.webApp.webApp.controller;

import com.webApp.webApp.dto.UserDto;
import com.webApp.webApp.dto.mapper.UserMapper;
import com.webApp.webApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userServiceImpl;

    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userServiceImpl, UserMapper userMapper) {
        this.userServiceImpl = userServiceImpl;
        this.userMapper = userMapper;
    }

    @GetMapping("/getusers")
    public List<UserDto> getUsers(){
        return userMapper.usersToUsersDto(userServiceImpl.getUsers());
    }

    @GetMapping("/getuserbyid")
    public UserDto getUserById(@RequestParam Integer id){
        return userMapper.userToUserDto(userServiceImpl.getUserById(id));
    }

    @GetMapping("/getusersbyname")
    public List<UserDto> getUsersByName(@RequestParam String name){
        return userMapper.usersToUsersDto(userServiceImpl.getUsersByName(name));
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody UserDto userDto) {
        userServiceImpl.addUser(userMapper.userDtoToUser(userDto));
    }

    @DeleteMapping("/deleteuser")
    public void deleteUser(@RequestParam Integer id) {
        userServiceImpl.deleteUser(id);
    }

    @PatchMapping("/updateuser")
    public void updateUser(@RequestBody UserDto userDto) {
        userServiceImpl.updateUser(userMapper.userDtoToUser(userDto));
    }

    @PatchMapping("/updateusername")
    public void updateUserFirstName(@RequestBody UserDto userDto) {
        userServiceImpl.updateUserFirstName(userMapper.userDtoToUser(userDto));
    }
}

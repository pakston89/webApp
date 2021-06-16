package com.webApp.webApp.controller;

import com.webApp.webApp.dto.UserDto;
import com.webApp.webApp.dto.mapper.UserMapper;
import com.webApp.webApp.service.UserService;
import com.webApp.webApp.utils.LogConstants;
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
        LogConstants.UserControllerLOG.info("Method: getUsers -- Params: " + "none");
        return userMapper.usersToUsersDto(userServiceImpl.getUsers());
    }

    @GetMapping("/getuserbyid")
    public UserDto getUserById(@RequestParam Integer id){
        LogConstants.UserControllerLOG.info("Method: getUserById -- Params: " + id);
        return userMapper.userToUserDto(userServiceImpl.getUserById(id));
    }

    @GetMapping("/getusersbyname")
    public List<UserDto> getUsersByName(@RequestParam String name){
        LogConstants.UserControllerLOG.info("Method: getUserByName -- Params: " + name);
        return userMapper.usersToUsersDto(userServiceImpl.getUsersByName(name));
    }

    @GetMapping("/getdecryptedcardnumberbyuserid")
    public String getDecryptedCardNumberByUserId(@RequestParam Integer id){
        LogConstants.UserControllerLOG.info("Method: getDecryptedCardNumberByUserId -- Params: " + id);
        return userServiceImpl.getDecryptedCardNumberByUserId(id);
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody UserDto userDto) {
        LogConstants.UserControllerLOG.info("Method: addUser -- Params: " + userDto.toString());
        userServiceImpl.addUser(userMapper.userDtoToUser(userDto));
    }

    @DeleteMapping("/deleteuser")
    public void deleteUser(@RequestParam Integer id) {
        LogConstants.UserControllerLOG.info("Method: deleteUser -- Params: " + id);
        userServiceImpl.deleteUser(id);
    }

    @PatchMapping("/updateuser")
    public void updateUser(@RequestBody UserDto userDto) {
        LogConstants.UserControllerLOG.info("Method: updateUser -- Params: " + userDto.toString());
        userServiceImpl.updateUser(userMapper.userDtoToUser(userDto));
    }

    @PatchMapping("/updateuserfirstname")
    public void updateUserFirstName(@RequestBody UserDto userDto) {
        LogConstants.UserControllerLOG.info("Method: updateUserFirstName -- Params: " + userDto.toString());
        userServiceImpl.updateUserFirstName(userMapper.userDtoToUser(userDto));
    }
}

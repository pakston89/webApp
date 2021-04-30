package com.webApp.webApp.service;

import com.webApp.webApp.model.User;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public ResponseEntity<User> getUserOut(String id);

    public User getUserById(Integer id);

    public List<User> getUserByName(String name);

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);

    public void updateUserName(User user);
}

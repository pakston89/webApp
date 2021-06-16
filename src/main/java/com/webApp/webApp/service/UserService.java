package com.webApp.webApp.service;

import com.webApp.webApp.model.User;
import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUserById(Integer id);

    public String getDecryptedCardNumberByUserId(Integer id);

    public List<User> getUsersByName(String name);

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user);

    public void updateUserFirstName(User user);
}

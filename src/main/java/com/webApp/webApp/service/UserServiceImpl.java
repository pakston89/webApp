package com.webApp.webApp.service;

import com.google.common.base.Strings;
import com.webApp.webApp.repository.UserRepository;
import com.webApp.webApp.model.User;
import com.webApp.webApp.security.Cipher.AES256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id){
        if (id > 0){
            return userRepository.findByID(id);
        }
        else{
            return null;
        }
    }

    @Override
    public List<User> getUsersByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public void addUser(User user) {
	    user.setRegistrationDate(LocalDate.now());
        String secretKey = AES256.getRandomKey();
        String salt = AES256.getRandomKey();
	    user.setCardNumber(AES256.encrypt(user.getCardNumber(), secretKey, salt));
        user.setSecretKey(secretKey);
        user.setSalt(salt);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(userRepository.findByID(id));
        userRepository.flush();
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = userRepository.findByID(user.getId());

        if(!Strings.isNullOrEmpty(user.getFirstName())) {
            userToUpdate.setFirstName(user.getFirstName());
        }

        if(!Strings.isNullOrEmpty(user.getLastName())) {
            userToUpdate.setLastName(user.getLastName());
        }

        if(!Strings.isNullOrEmpty(user.getNif())) {
            userToUpdate.setNif(user.getNif());
        }

        if(!Strings.isNullOrEmpty(user.getCardNumber())) {
            String secretKey = AES256.getRandomKey();
            String salt = AES256.getRandomKey();
            userToUpdate.setCardNumber(AES256.encrypt(user.getCardNumber(), secretKey, salt));
            userToUpdate.setSecretKey(secretKey);
            userToUpdate.setSalt(salt);
        }

        if(user.getRegistrationDate() != null) {
            userToUpdate.setRegistrationDate(user.getRegistrationDate());
        }

        userRepository.saveAndFlush(userToUpdate);
    }

    @Override
    public void updateUserFirstName(User user) {
        User userToUpdate = userRepository.findByID(user.getId());

        if(!Strings.isNullOrEmpty(user.getFirstName())) {
            userToUpdate.setFirstName(user.getFirstName());
        }

        userRepository.saveAndFlush(userToUpdate);
    }
}

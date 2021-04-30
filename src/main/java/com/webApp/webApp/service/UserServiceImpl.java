package com.webApp.webApp.service;

import com.webApp.webApp.repository.UserRepository;
import com.webApp.webApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemp;

    @Autowired
	private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> getUserOut(String id){
        String url = String.format("http://localhost:5000/getUserByIdIn?userId=%s", id);
        ResponseEntity<User> respuesta = null;
        try{
            respuesta = restTemp.getForEntity(url, User.class);
            User user = respuesta.getBody();
        }
        catch(Exception e){

        }
        return respuesta;
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
    public List<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public void addUser(User user) {
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
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setNif(user.getNif());
        userToUpdate.setRegistrationDate(user.getRegistrationDate());
        userRepository.saveAndFlush(userToUpdate);
    }

    @Override
    public void updateUserName(User user) {
        User userToUpdate = userRepository.findByID(user.getId());
        userToUpdate.setFirstName(user.getFirstName());
        userRepository.saveAndFlush(userToUpdate);
    }
}

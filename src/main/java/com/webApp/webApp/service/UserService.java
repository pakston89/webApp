package com.webApp.webApp.service;
import com.webApp.webApp.repository.UserRepository;
import com.webApp.webApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemp;
    @Autowired
	private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserOut(String id){
        String url = String.format("http://localhost:5000/getUserByIdIn?userId=%s", id);
        ResponseEntity<User> respuesta = null;
        try{
            respuesta = restTemp.getForEntity(url, User.class);
            User user = respuesta.getBody();
        }
        catch(Exception e){
            System.out.println("Se ha producido un error en la comunicación: " + e);
        }
        return respuesta;
    }
    public User getUser(Integer id){
        if (id > 0){
            return userRepository.findByID(id);
        }
        else{
            return null;
        }
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.delete(userRepository.findByID(id));
        userRepository.flush();
    }

    public void updateUser(User user) {
        User userToUpdate = userRepository.findByID(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setNif(user.getNif());
        userToUpdate.setRegistrationDate(user.getRegistrationDate());
        userRepository.saveAndFlush(userToUpdate);
    }

    public void updateUserName(User user) {
        User userToUpdate = userRepository.findByID(user.getId());
        userToUpdate.setName(user.getName());
        userRepository.saveAndFlush(userToUpdate);
    }
}

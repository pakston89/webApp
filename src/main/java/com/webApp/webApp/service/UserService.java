package com.webApp.webApp.service;
import com.webApp.webApp.repository.UserRepository;
import com.webApp.webApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.transaction.Transactional;
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

    public ResponseEntity<User[]> getUserOut(String userId){
        String url = String.format("https://jsonplaceholder.typicode.com/posts?userId=%s", userId);
        ResponseEntity<User[]> respuesta = null;
        try{
            respuesta = restTemp.getForEntity(url, User[].class);
            User[] users = respuesta.getBody();
        }
        catch(Exception e){
            System.out.println("Se ha producido un error en la comunicación");
        }
        return respuesta;
    }
    public User getUser(Integer userId){
        if (userId > 0){
            return userRepository.findByUserId(userId);
        }
        else{
            return null;
        }
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.delete(userRepository.findByUserId(userId));
        userRepository.flush();
    }

    public void updateUser(User user) {
        User userToUpdate = userRepository.findByUserId(user.getUserId());
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setUserLastName(user.getUserLastName());
        userToUpdate.setUserNif(user.getUserNif());
        userToUpdate.setRegistrationDate(user.getRegistrationDate());
        userRepository.saveAndFlush(userToUpdate);
    }
}

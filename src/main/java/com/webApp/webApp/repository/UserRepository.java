package com.webApp.webApp.repository;
import com.webApp.webApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.id=?1")
    User findByID(@Param("id") Integer id);

}



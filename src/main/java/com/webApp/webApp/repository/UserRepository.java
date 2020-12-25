package com.webApp.webApp.repository;
import com.webApp.webApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE id=?1", nativeQuery = true)
    User findByID(@Param("id") Integer id);

    @Query(value = "SELECT * FROM users WHERE name LIKE %?1%", nativeQuery = true)
    List<User> findByName(@Param("name") String name);
}



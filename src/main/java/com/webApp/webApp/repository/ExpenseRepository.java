package com.webApp.webApp.repository;

import com.webApp.webApp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Query(value = "SELECT * FROM expenses WHERE id=?1", nativeQuery = true)
    Expense findByID(Integer id);

    @Query(value = "SELECT * FROM expenses WHERE description LIKE %?1%", nativeQuery = true)
    List<Expense> findByDescription(String description);
}



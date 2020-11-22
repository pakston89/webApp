package com.webApp.webApp.repository;
import com.webApp.webApp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Query("SELECT e FROM Expense e WHERE e.id=?1")
    Expense findByID(@Param("id") Integer Id);
}



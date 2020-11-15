package com.webApp.webApp.repository;
import com.webApp.webApp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    Expense findByExpenseId(@Param("expenseId") Integer expenseId);
}



package com.webApp.webApp.repository;

import com.webApp.webApp.model.Expense;
import com.webApp.webApp.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {

    @Query(value = "SELECT * FROM expense_types WHERE id=?1", nativeQuery = true)
    ExpenseType findByID(@Param("id") Integer id);

    @Query(value = "SELECT * FROM expense_types WHERE description LIKE %?1%", nativeQuery = true)
    List<ExpenseType> findByDescription(@Param ("description") String description);
}

package com.webApp.webApp.repository;

import com.webApp.webApp.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {

    @Query(value = "SELECT * FROM expense_types WHERE id=?1", nativeQuery = true)
    ExpenseType findByID(Integer id);

    @Query(value = "SELECT * FROM expense_types WHERE description LIKE %?1%", nativeQuery = true)
    List<ExpenseType> findByDescription(String description);
}

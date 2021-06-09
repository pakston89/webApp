package com.webApp.webApp.service;

import com.webApp.webApp.model.ExpenseType;
import java.util.List;

public interface ExpenseTypeService {

    public List<ExpenseType> getExpenseTypes();

    public ExpenseType getExpenseTypeById(Integer id);

    public List<ExpenseType> getExpenseTypesByDescription(String description);
}

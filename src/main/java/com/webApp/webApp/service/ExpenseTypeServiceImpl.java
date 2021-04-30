package com.webApp.webApp.service;

import com.webApp.webApp.model.ExpenseType;
import com.webApp.webApp.repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Override
    public List<ExpenseType> getExpenseTypes(){
        return expenseTypeRepository.findAll();
    }

    @Override
    public ExpenseType getExpenseTypeById(Integer id){
        return expenseTypeRepository.findByID(id);
    }

    @Override
    public List<ExpenseType> getExpenseTypeByDescription(String description){
        return expenseTypeRepository.findByDescription(description);
    }
}

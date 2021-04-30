package com.webApp.webApp.controller;

import com.webApp.webApp.model.ExpenseType;
import com.webApp.webApp.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ExpenseTypeController {

    @Autowired
    private ExpenseTypeService expenseTypeServiceImpl;

    @GetMapping("/getExpenseTypes")
    public List<ExpenseType> getExpenses(){
        return expenseTypeServiceImpl.getExpenseTypes();
    }
    @GetMapping("/getExpenseTypeById")
    public ExpenseType getExpenseById(@RequestParam Integer id){
        return expenseTypeServiceImpl.getExpenseTypeById(id);
    }
    @GetMapping("/getExpenseTypeByDescription")
    public List<ExpenseType> getExpenseTypeByDescription(@RequestParam String description){
        return expenseTypeServiceImpl.getExpenseTypeByDescription(description);
    }
}

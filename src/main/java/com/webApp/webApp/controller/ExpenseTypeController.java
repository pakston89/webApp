package com.webApp.webApp.controller;

import com.webApp.webApp.model.ExpenseType;
import com.webApp.webApp.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class ExpenseTypeController {

    @Autowired
    ExpenseTypeService expenseTypeService;

    @GetMapping("/getExpenseTypes")
    public List<ExpenseType> getExpenses(){
        return expenseTypeService.getExpenseTypes();
    }
    @GetMapping("/getExpenseTypeById")
    public ExpenseType getExpenseById(@RequestParam Integer id){
        return expenseTypeService.getExpenseTypeById(id);
    }
    @GetMapping("/getExpenseTypeByDescription")
    public List<ExpenseType> getExpenseTypeByDescription(@RequestParam String description){
        return expenseTypeService.getExpenseTypeByDescription(description);
    }
}

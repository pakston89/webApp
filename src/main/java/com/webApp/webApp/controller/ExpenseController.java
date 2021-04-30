package com.webApp.webApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webApp.webApp.model.Expense;
import com.webApp.webApp.service.ExpenseService;
import com.webApp.webApp.service.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseServiceImpl;

    @GetMapping("/getExpenses")
    public List<Expense> getExpenses(){
        return expenseServiceImpl.getExpenses();
    }
    @GetMapping("/getExpenseById")
    public Expense getExpenseById(@RequestParam Integer id){
        return expenseServiceImpl.getExpenseById(id);
    }
    @GetMapping("/getExpenseByDescription")
    public List<Expense> getExpenseByDescription(@RequestParam String description){
      return expenseServiceImpl.getExpenseByDescription(description);
    }
    @PostMapping("/addExpenseIn")
    public void addUser(@RequestBody Expense expense){
        expenseServiceImpl.addExpense(expense);
    }
    @DeleteMapping("/deleteExpenseIn")
    public void deleteExpense(@RequestParam Integer id) {
        expenseServiceImpl.deleteExpense(id);
    }
    @PutMapping("/updateExpenseIn")
    public void updateExpense(@RequestBody Expense expense) throws JsonProcessingException {
        expenseServiceImpl.updateExpense(expense);
    }
    @PatchMapping("/updateExpenseDescriptionIn")
    public void updateExpenseDescription(@RequestBody Expense expense) {
        expenseServiceImpl.updateExpenseDescription(expense);
    }
}

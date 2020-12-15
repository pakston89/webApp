package com.webApp.webApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webApp.webApp.model.Expense;
import com.webApp.webApp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class ExpenseController {
 
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/getExpenses")
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
    }

    @GetMapping("/getExpenseByIdIn")
    public Expense getExpense(@RequestParam Integer id){
        return expenseService.getExpense(id);
    }

    @PostMapping("/addExpenseIn")
    public void addUser(@RequestBody Expense expense) throws JsonProcessingException {
        expenseService.addExpense(expense);
    }

    @DeleteMapping("/deleteExpenseIn")
    public void deleteExpense(@RequestParam Integer id) {
        expenseService.deleteExpense(id);
    }

    @PutMapping("/updateExpenseIn")
    public void updateExpense(@RequestBody Expense expense) throws JsonProcessingException {
        expenseService.updateExpense(expense);
    }

    @PatchMapping("/updateExpenseDescriptionIn")
    public void updateExpenseDescription(@RequestBody Expense expense) {
        expenseService.updateExpenseDescription(expense);
    }
}

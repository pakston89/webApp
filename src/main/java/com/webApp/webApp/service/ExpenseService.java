package com.webApp.webApp.service;

import com.webApp.webApp.model.Expense;
import com.webApp.webApp.model.User;
import com.webApp.webApp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
	private ExpenseRepository expenseRepository;

    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpense(Integer id){
        if (id > 0){
            return expenseRepository.findByID(id);
        }
        else{
            return null;
        }
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.delete(expenseRepository.findByID(id));
        expenseRepository.flush();
    }

    public void updateExpense(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findByID(expense.getId());
        expenseToUpdate.setDescription(expense.getDescription());
        expenseToUpdate.setAmount(expense.getAmount());
        expenseToUpdate.setUser(expense.getUser());
        expenseRepository.saveAndFlush(expenseToUpdate);
    }

    public void updateExpenseDescription(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findByID(expense.getId());
        expenseToUpdate.setDescription(expense.getDescription());
        expenseRepository.saveAndFlush(expenseToUpdate);
    }
}

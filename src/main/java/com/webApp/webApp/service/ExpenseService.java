package com.webApp.webApp.service;

import com.webApp.webApp.model.Expense;
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

    public Expense getExpense(Integer expenseId){
        if (expenseId > 0){
            return expenseRepository.findByExpenseId(expenseId);
        }
        else{
            return null;
        }
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Integer expenseId) {
        expenseRepository.delete(expenseRepository.findByExpenseId(expenseId));
        expenseRepository.flush();
    }

    public void updateExpense(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findByExpenseId(expense.getExpenseId());
        expenseToUpdate.setExpenseDescription(expense.getExpenseDescription());
        expenseToUpdate.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.saveAndFlush(expenseToUpdate);
    }

    public void updateExpenseDescription(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findByExpenseId(expense.getExpenseId());
        expenseToUpdate.setExpenseDescription(expense.getExpenseDescription());
        expenseRepository.saveAndFlush(expenseToUpdate);
    }
}

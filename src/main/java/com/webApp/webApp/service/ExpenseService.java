package com.webApp.webApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webApp.webApp.model.Expense;

import java.util.List;

public interface ExpenseService {

    public List<Expense> getExpenses();

    public Expense getExpenseById(Integer id);

    public List<Expense> getExpenseByDescription(String description);

    public void addExpense(Expense expense);

    public void deleteExpense(Integer id);

    public void updateExpense(Expense expense) throws JsonProcessingException;

    public void updateExpenseDescription(Expense expense);
}

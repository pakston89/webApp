package com.webApp.webApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webApp.webApp.model.Expense;
import com.webApp.webApp.repository.ExpenseRepository;
import com.webApp.webApp.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
	private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Integer id){
        if(id > 0){
            return expenseRepository.findByID(id);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Expense> getExpenseByDescription(String description){
      return expenseRepository.findByDescription(description);
    }

    @Override
    public void addExpense(Expense expense){
        Double amountInEuros = Utils.convertAmountToEuros(expense.getAmount(), expense.getCurrency());
        expense.setAmount(amountInEuros);
        expense.setCurrency("EUR");
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        expenseRepository.delete(expenseRepository.findByID(id));
        expenseRepository.flush();
    }

    @Override
    public void updateExpense(Expense expense) throws JsonProcessingException {
        Expense expenseToUpdate = expenseRepository.findByID(expense.getId());
        expenseToUpdate.setDescription(expense.getDescription());
        expenseToUpdate.setAmount(Utils.convertAmountToEuros(expense.getAmount(), expense.getCurrency()));
        expenseToUpdate.setUser(expense.getUser());
        expenseRepository.saveAndFlush(expenseToUpdate);
    }

    @Override
    public void updateExpenseDescription(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findByID(expense.getId());
        expenseToUpdate.setDescription(expense.getDescription());
        expenseRepository.saveAndFlush(expenseToUpdate);
    }
}

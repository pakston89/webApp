package com.webApp.webApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Strings;
import com.webApp.webApp.model.Expense;
import com.webApp.webApp.repository.ExpenseRepository;
import com.webApp.webApp.utils.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseRepository expenseRepository;

	@Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

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
        Double amountInEuros = CurrencyConversion.convertAmountToEuros(expense.getAmount(), expense.getCurrency());
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

        if(!Strings.isNullOrEmpty(expense.getDescription())) {
            expenseToUpdate.setDescription(expense.getDescription());
        }

        if(expense.getAmount() != null) {
            expenseToUpdate.setAmount(CurrencyConversion.convertAmountToEuros(expense.getAmount(), expense.getCurrency()));
        }

        if(expense.getExpenseTypeId() != null) {
            expenseToUpdate.setExpenseTypeId(expense.getExpenseTypeId());
        }

        if(expense.getUserId() != null) {
            expenseToUpdate.setUserId(expense.getUserId());
        }

        expenseRepository.saveAndFlush(expenseToUpdate);
    }

    @Override
    public void updateExpenseDescription(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findByID(expense.getId());

        if(!Strings.isNullOrEmpty(expense.getDescription())) {
            expenseToUpdate.setDescription(expense.getDescription());
        }

        expenseRepository.saveAndFlush(expenseToUpdate);
    }
}

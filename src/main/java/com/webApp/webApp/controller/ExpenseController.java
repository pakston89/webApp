package com.webApp.webApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webApp.webApp.dto.ExpenseDto;
import com.webApp.webApp.dto.mapper.ExpenseMapper;
import com.webApp.webApp.service.ExpenseService;
import com.webApp.webApp.utils.LogConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService expenseServiceImpl;

    private ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseController(ExpenseService expenseServiceImpl, ExpenseMapper expenseMapper) {
        this.expenseServiceImpl = expenseServiceImpl;
        this.expenseMapper = expenseMapper;
    }

    @GetMapping("/getexpenses")
    public List<ExpenseDto> getExpenses() {
        LogConstants.ExpenseControllerLOG.info("Method: getExpenses -- Params: " + "none");
        return expenseMapper.expensesToExpensesDto(expenseServiceImpl.getExpenses());
    }

    @GetMapping("/getexpensebyid")
    public ExpenseDto getExpenseById(@RequestParam Integer id) {
        LogConstants.ExpenseControllerLOG.info("Method: getExpenseById -- Params: " + id);
        return expenseMapper.expenseToExpenseDto(expenseServiceImpl.getExpenseById(id));
    }

    @GetMapping("/getexpensesbydescription")
    public List<ExpenseDto> getExpenseByDescription(@RequestParam String description) {
        LogConstants.ExpenseControllerLOG.info("Method: getExpensesByDescription -- Params: " + description);
        return expenseMapper.expensesToExpensesDto(expenseServiceImpl.getExpenseByDescription(description));
    }

    @PostMapping("/addexpense")
    public void addExpense(@RequestBody ExpenseDto expenseDto) {
        LogConstants.ExpenseControllerLOG.info("Method: addExpense -- Params: " + expenseDto.toString());
        expenseServiceImpl.addExpense(expenseMapper.expenseDtoToExpense(expenseDto));
    }

    @DeleteMapping("/deleteexpense")
    public void deleteExpense(@RequestParam Integer id) {
        LogConstants.ExpenseControllerLOG.info("Method: deleteExpense -- Params: " + id);
        expenseServiceImpl.deleteExpense(id);
    }

    @PatchMapping("/updateexpense")
    public void updateExpense(@RequestBody ExpenseDto expenseDto) throws JsonProcessingException {
        LogConstants.ExpenseControllerLOG.info("Method: updateExpense -- Params: " + expenseDto.toString());
        expenseServiceImpl.updateExpense(expenseMapper.expenseDtoToExpense(expenseDto));
    }

    @PatchMapping("/updateexpensedescription")
    public void updateExpenseDescription(@RequestBody ExpenseDto expenseDto) {
        LogConstants.ExpenseControllerLOG.info("Method: updateExpenseDescription -- Params: " + expenseDto.toString());
        expenseServiceImpl.updateExpenseDescription(expenseMapper.expenseDtoToExpense(expenseDto));
    }
}

package com.webApp.webApp.controller;

import com.webApp.webApp.dto.ExpenseTypeDto;
import com.webApp.webApp.dto.mapper.ExpenseTypeMapper;
import com.webApp.webApp.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/expensetype")
public class ExpenseTypeController {

    private ExpenseTypeService expenseTypeServiceImpl;

    private ExpenseTypeMapper expenseTypeMapper;

    @Autowired
    public ExpenseTypeController(ExpenseTypeService expenseTypeServiceImpl, ExpenseTypeMapper expenseTypeMapper) {
        this.expenseTypeServiceImpl = expenseTypeServiceImpl;
        this.expenseTypeMapper = expenseTypeMapper;
    }

    @GetMapping("/getexpensetypes")
    public List<ExpenseTypeDto> getExpenseTypes(){
        return expenseTypeMapper.expenseTypesToExpenseTypesDto(expenseTypeServiceImpl.getExpenseTypes());
    }

    @GetMapping("/getexpensetypebyid")
    public ExpenseTypeDto getExpenseTypeById(@RequestParam Integer id){
        return expenseTypeMapper.expenseTypeToExpenseTypeDto(expenseTypeServiceImpl.getExpenseTypeById(id));
    }

    @GetMapping("/getexpensetypesbydescription")
    public List<ExpenseTypeDto> getExpenseTypesByDescription(@RequestParam String description){
        return expenseTypeMapper.expenseTypesToExpenseTypesDto(expenseTypeServiceImpl.getExpenseTypesByDescription(description));
    }
}

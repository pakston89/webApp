package com.webApp.webApp.dto.mapper;

import com.webApp.webApp.dto.ExpenseTypeDto;
import com.webApp.webApp.model.ExpenseType;
import org.mapstruct.Mapper;
import java.util.List;

//ComponentModel = "spring" produce un bean para poderlo inyectar donde queramos.
@Mapper(componentModel = "spring")
public interface ExpenseTypeMapper {

    ExpenseTypeDto expenseTypeToExpenseTypeDto(ExpenseType expenseType);

    List<ExpenseTypeDto> expenseTypesToExpenseTypesDto(List<ExpenseType> expenseType);

    ExpenseType expenseTypeDtoToExpenseType(ExpenseTypeDto expenseTypeDto);
}

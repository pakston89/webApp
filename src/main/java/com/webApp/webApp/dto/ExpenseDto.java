package com.webApp.webApp.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.webApp.webApp.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExpenseDto {

    private Integer id;

    private String description;

    private Integer expenseTypeId;

    private Double amount;

    private String currency;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;
}

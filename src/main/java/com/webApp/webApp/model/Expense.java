package com.webApp.webApp.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "expenses")
@Getter @Setter
@ToString
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "expense_type_id")
    private Integer expenseTypeId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "user_id")
    private Integer userId;

    public Expense() {

    }

    public Expense(Integer id, String description, Integer expenseTypeId, Double amount, String currency, Integer userId) {
        this.id = id;
        this.description = description;
        this.expenseTypeId = expenseTypeId;
        this.amount = amount;
        this.currency = currency;
        this.userId = userId;
    }
}

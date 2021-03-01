package com.webApp.webApp.model;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expenses")
@Getter @Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "expense_type_id")
    private Integer expenseTypeId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "currency")
    private String currency;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense() {

    }

    public Expense(Integer id, String description, Integer expenseTypeId, double amount, String currency, User user) {
        this.id = id;
        this.description = description;
        this.expenseTypeId = expenseTypeId;
        this.amount = amount;
        this.currency = currency;
        this.user = user;
    }
}

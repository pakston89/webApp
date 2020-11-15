package com.webApp.webApp.model;

import javax.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_KEY")
    private Integer idKey;
    @Column(name = "EXPENSE_ID")
    private Integer expenseId;
    @Column(name = "EXPENSE_DESCRIPTION")
    private String expenseDescription;
    @Column(name = "EXPENSE_AMOUNT")
    private double expenseAmount;
    @Column(name = "USER_ID")
    private Integer userId;

    public Expense() {

    }

    public Expense(Integer idKey, Integer expenseId, String expenseDescription, double expenseAmount, Integer userId) {
        this.idKey = idKey;
        this.expenseId = expenseId;
        this.expenseDescription = expenseDescription;
        this.expenseAmount = expenseAmount;
        this.userId = userId;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double amount) {
        this.expenseAmount = expenseAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

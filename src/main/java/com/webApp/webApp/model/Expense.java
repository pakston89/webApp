package com.webApp.webApp.model;

import javax.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense() {

    }

    public Expense(Integer id, String description, double amount, User user) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

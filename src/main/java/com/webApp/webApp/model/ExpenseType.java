package com.webApp.webApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "expense_types")
@Getter @Setter
@ToString
public class ExpenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    public ExpenseType() {

    }

    public ExpenseType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
}

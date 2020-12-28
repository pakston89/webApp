package com.webApp.webApp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Entity
@Table(name = "expenses")
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

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Integer expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private HttpResponse<String> RequestToCurrencyExchange(String fromCurrency){
        String url = String.format("http://data.fixer.io/api/latest?access_key=6eb751287d171bb40c9e732ded8c71c7&symbols=%s", fromCurrency);
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch(Exception e){

        }
        return response;
    }

    public Double CurrencyExchangeResponseMapper (String fromCurrency){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(RequestToCurrencyExchange(fromCurrency).body());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JsonNode rates = root.path("rates");
        JsonNode currency = rates.get(fromCurrency);
        Double rate = currency.asDouble();
        return rate;
    }

    public Double convertAmountToEuros(Double amountToConvert, String fromCurrency) throws JsonProcessingException {
        Double amountInEuros = amountToConvert / CurrencyExchangeResponseMapper(fromCurrency);
        Double amountInEurosRounded = Math.round(amountInEuros * 100.0) / 100.0;
        return amountInEurosRounded;
    }
}

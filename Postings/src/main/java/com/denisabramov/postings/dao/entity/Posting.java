package com.denisabramov.postings.dao.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "postings")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CsvBindByName(column = "Mat. Doc.", capture = "([^ ]+).*")
    private String postingNumber;
    @CsvBindByName(column = "Item")
    private int itemsAmount;
    @CsvBindByName(column = "Doc. Date", capture = ".([^ ]+).*")
    @CsvDate("dd.MM.yyyy")
    private LocalDate docDate;
    @CsvBindByName(column = "Pstng Date", capture = ".([^ ]+).*")
    @CsvDate("dd.MM.yyyy")
    private LocalDate postingDate;
    @CsvBindByName(column = "Material Description")
    private String description;
    @CsvBindByName(column = "Quantity", capture = ".([^ ]+).*")
    private int quantity;
    @CsvBindByName(column = "BUn")
    private String unit;
    @CsvBindByName(column = "Amount LC", capture = ".([^ ]+).*", locale = "ru-RU")
    @CsvNumber(value = "#,#")
    private double amount;
    @CsvBindByName(column = "Crcy")
    private String currency;
    @CsvBindByName(column = "User Name")
    private String username;
    private boolean isAuthorized;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostingNumber() {
        return postingNumber;
    }

    public void setPostingNumber(String postingNumber) {
        this.postingNumber = postingNumber;
    }

    public int getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(int itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit.trim();
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
        this.currency = currency.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "id=" + id +
                ", postingNumber='" + postingNumber + '\'' +
                ", itemsAmount=" + itemsAmount +
                ", docDate=" + docDate +
                ", postingDate=" + postingDate +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", username='" + username + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}

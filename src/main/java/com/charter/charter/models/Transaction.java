package com.charter.charter.models;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    int id;

    @Column
    int receipt;

    @Column
    int points;

    @ManyToOne
    private Customer customer;

    public Transaction(){
    }

    public Transaction(Customer customer, int receipt) {
        this.receipt = receipt;
        this.customer = customer;
        calculatePoints(receipt);
    }

    //TODO IMPORTANT! aggregate total points per Customer and display with React js
    //TODO explain in documentation that
    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }

    public int getPoints() { return points; }

    public void setPoints(int points) { this.points = points; }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void calculatePoints(Integer input) {
        if (input < 51 || input == null) this.points = 0;
        else if (input < 101) this.points = input - 50;
        else this.points = ((input - 100) * 2) + 50;
    }

}

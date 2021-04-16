package com.charter.charter.models;

import com.sun.istack.NotNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    int id;

    @Column
    private String name;

    @Column
    private int points;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Transaction> transactions = new ArrayList<>();

    public Customer(){
    }

    public Customer(String name) {
        this.name = name;
        this.transactions = transactions;
        this.points = 0;
    }

    public Customer(int id) {
        this.id = id;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addpoints(int points){
        this.points += points;
    }
}

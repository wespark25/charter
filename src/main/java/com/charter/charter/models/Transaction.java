package com.charter.charter.models;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    int id;

    @Column
    String name;

    @Column
    int receipt;



    @Column
    int points;

    public Transaction(){
    }

    public Transaction(String name, int receipt) {
        this.name = name;
        this.receipt = receipt;
        calculatePoints(receipt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }

    public int getPoints() { return points; }

    public void setPoints(int points) { this.points = points; }

    public void calculatePoints(Integer input) {
        if (input < 51 || input == null) this.points = 0;
        else if (input < 101) this.points = input - 50;
        else this.points = ((input - 100) * 2) + 50;
    }

}

package com.charter.charter.models;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
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

    @Column
    Date date;

    @Column
    boolean old;

    @ManyToOne
    private Customer customer;

    public Transaction(){
    }

    //TODO Move the logic of checking if a customer exists to here. Also, verify that that is in line with good programming practices.
    public Transaction(Customer customer, int receipt, Date date) {
        this.customer = customer;
        this.receipt = receipt;
        this.date = date;
        calculatePoints(receipt,date);
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isOld() {
        return old;
    }


    public void setOld(boolean old) {
        this.old = old;
    }

    public void calculatePoints(Integer input, Date date) {
        //Checking if provided date is within past three months
        if(date.after(Date.from(ZonedDateTime.now().minusMonths(3).toInstant()))) {
            if (input < 51 || input == null) this.points = 0;
            else if (input < 101) this.points = input - 50;
            else this.points = ((input - 100) * 2) + 50;
            this.old = false;
        }
        else this.old = true;
    }

}

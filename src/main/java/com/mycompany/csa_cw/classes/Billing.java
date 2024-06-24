/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.classes;



/**
 *
 * @author HP
 */





public class Billing {
    private int id;
    private String patient;
    private double amount;
    private String paymentDate;

    // create constructor
    public Billing(int id, String patient, double amount, String paymentDate) {
        this.id = id;
        this.patient = patient;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // create default constructor
    public Billing() {
        this.id = 0;
        this.patient = "";
        this.amount = 0.0;
        this.paymentDate = "";
    }

    // getters to get id
    public int getId() {
        return id;
    }

    // setters to set id
    public void setId(int id) {
        this.id = id;
    }

    // getters to get patient
    public String getPatient() {
        return patient;
    }

    // setters to set patient
    public void setPatient(String patient) {
        this.patient = patient;
    }

    // getters to get amoout
    public double getAmount() {
        return amount;
    }

    // setters to set amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // getters to get date
    public String getPaymentDate() {
        return paymentDate;
    }

    // setters to set date
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
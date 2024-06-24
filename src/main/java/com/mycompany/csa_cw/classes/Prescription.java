/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.classes;



/**
 *
 * @author HP
 */



public class Prescription {

    private int id;
    private String dose;
    private String medications;
    private int date;
    private Patient patient;
    
    // deafult constructor
    public Prescription(){}
    
    // create constrctor
    public Prescription(int id, String dose, String medications, int date, Patient patient){
        this.id = id;
        this.dose = dose;
        this.medications = medications;
        this.date = date;
        this.patient = patient;
    }

    // getters and setters are initialized the below
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public int getDate() {
        return date;
    }

    public void setDuratios(int date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}
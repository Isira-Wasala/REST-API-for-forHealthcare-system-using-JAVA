/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.classes;

/**
 *
 * @author HP
 */


public class Patient extends Person {
    private String medicalHistory;
    private String currentHealthStatus;

// create constructor
    public Patient(int id, String name, String contactInfo, String address, String medicalHistory, String currentHealthStatus) {
        super(id, name, contactInfo, address);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
    
        // Default constructor
    public Patient() {
        super(0, "", "", "");
        this.medicalHistory = "";
        this.currentHealthStatus = "";
    }

    // getters and setters are initialized the below
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}
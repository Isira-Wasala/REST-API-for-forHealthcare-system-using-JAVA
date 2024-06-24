/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.classes;

/**
 *
 * @author HP
 */


import com.mycompany.csa_cw.classes.Doctor;
import com.mycompany.csa_cw.classes.Patient;

public class Appointment {
    
    // initialized the varibales
    private int id;
    private String date;
    private String time;
    private Patient patient;
    private Doctor doctor;

    // default constructor
    public Appointment() {}

    // create and initializing the constructor and values
    public Appointment(int id, String date, String time, Patient patient, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }

    // getters to get Id
    public int getId() {
        return id;
    }

    // settters to set id
    public void setId(int id) {
        this.id = id;
    }

    // getters to get date
    public String getDate() {
        return date;
    }

    // setters to set date
    public void setDate(String date) {
        this.date = date;
    }

    // getters to get time
    public String getTime() {
        return time;
    }

    // setters to set time
    public void setTime(String time) {
        this.time = time;
    }

    // getters to get patients 
    public Patient getPatient() {
        return patient;
    }

    // getters to set patients
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // getters to get doctors
    public Doctor getDoctor() {
        return doctor;
    }

    // setters to set doctors
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.classes;

/**
 *
 * @author HP
 */


public class MedicalRecord {
    private int id;
    private String patientName;
    private String diagnosis;
    private String treatment;

    // create constructor
    public MedicalRecord(int id, String patientName, String diagnosis, String treatment) {
        this.id = id;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }
    
    // default constructor
    public MedicalRecord(){
        this.id=0;
        this.patientName=null;
        this.diagnosis=null;
        this.treatment=null;
    }

    // getters and setters are initialized the below
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
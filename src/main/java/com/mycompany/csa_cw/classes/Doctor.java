/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.classes;

public class Doctor extends Person {
    private String specialization;
    private String contactDetails;

    // Default constructor
    public Doctor() {
        super(0, "", "", "");
        this.specialization = "";
        this.contactDetails = "";
    }

    // create constructor
    public Doctor(int id, String name, String contactInfo, String address, String specialization, String contactDetails) {
        super(id, name, contactInfo, address);
        this.specialization = specialization;
        this.contactDetails = contactDetails;
    }

    // getters and setters are initialized the below
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}

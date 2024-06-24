/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;


/**
 *
 * @author HP
 */




import com.mycompany.csa_cw.classes.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PatientDAO extends PersonDAO {
    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());
    private static List<Patient> patients; 

    // Static block to initialize the list of patients
    static {
        patients = new ArrayList<>();
        // Initialize patients 
        patients.add(new Patient(1, "Isira Wasala", "0761232009", "Battaramulla, CMB", "Last checked : 2024/01/05", "Successfully Recovered !"));
        patients.add(new Patient(2, "Sahan Vimukthi", "0761234567", "Dope, Bentota", "Last checked : 2024/05/01", "Getting Recovered !"));
        patients.add(new Patient(3, "Kamal Perera", "0705729587", "Madampe, Chilaw", "Last checked : 2024/04/15", "Needs to attend clinics once a month !"));
    }

    // this method is creating patients
    public Patient createPatient(Patient patient) {
        try {
            patients.add(patient);
            LOGGER.info("Patient created: " + patient.getId());
            return patient;
        } catch (Exception ex) {
            LOGGER.severe("Error creating patient: " + ex.getMessage());
            throw new RuntimeException("Failed to create patient", ex);
        }
    }

    // getting patients
    public Patient getPatient(int id) {
        try {
            for (Patient patient : patients) {
                if (patient.getId() == id) {
                    return patient;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.severe("Error getting patient: " + ex.getMessage());
            throw new RuntimeException("Failed to get patient", ex);
        }
    }

    // get all patients at once
    public List<Patient> getAllPatients() {
        try {
            return patients;
        } catch (Exception ex) {
            LOGGER.severe("Error getting all patients: " + ex.getMessage());
            throw new RuntimeException("Failed to get all patients", ex);
        }
    }

    // update patients 
    public Patient updatePatient(Patient patient) {
        try {
            for (Patient p : patients) {
                if (p.getId() == patient.getId()) {
                    p.setMedicalHistory(patient.getMedicalHistory());
                    p.setCurrentHealthStatus(patient.getCurrentHealthStatus());
                    return p;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.severe("Error updating patient: " + ex.getMessage());
            throw new RuntimeException("Failed to update patient", ex);
        }
    }

    
    //delete the patients using id
    public boolean deletePatient(int id) {
        try {
            for (Patient patient : patients) {
                if (patient.getId() == id) {
                    patients.remove(patient);
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            LOGGER.severe("Error deleting patient: " + ex.getMessage());
            throw new RuntimeException("Failed to delete patient", ex);
        }
    }
}

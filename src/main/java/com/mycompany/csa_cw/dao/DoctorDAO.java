/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;

import com.mycompany.csa_cw.classes.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */



import java.util.logging.Logger;

public class DoctorDAO extends PersonDAO {
    private static final Logger LOGGER = Logger.getLogger(DoctorDAO.class.getName());
    private static List<Doctor> doctors = new ArrayList<>();

    static {
        // Initialize doctors 
        doctors.add(new Doctor(1, "Dr. Udam Wasala", "0765697856", "Chilaw, Chilaw", "Cardiologist", "udam.api@gmail.com"));
        doctors.add(new Doctor(2, "Dr. Vimukthi Dharmarathne", "0762359874", "5th rd, Chilaw", "Pediatrician", "vimukthi.api@gmail.com"));
        doctors.add(new Doctor(3, "Dr. Nimal Perera", "0712365980", "10th rd, battaramulla", "Dermatologist", "nimal.api@gmail.com"));
    }

    // creating doctors
    public Doctor createDoctor(Doctor doctor) {
        try {
            doctors.add(doctor);
            LOGGER.info("Doctor created: " + doctor.getId());
            return doctor;
        } catch (Exception ex) {
            LOGGER.severe("Error creating doctor: " + ex.getMessage());
            throw new RuntimeException("Failed to create doctor", ex);
        }
    }

    // getting doctors
    public Doctor getDoctor(int id) {
        try {
            for (Doctor doctor : doctors) {
                if (doctor.getId() == id) {
                    return doctor;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.severe("Error getting doctor: " + ex.getMessage());
            throw new RuntimeException("Failed to get doctor", ex);
        }
    }

    // get all the doctors at once
    public List<Doctor> getAllDoctors() {
        try {
            return doctors;
        } catch (Exception ex) {
            LOGGER.severe("Error getting all doctors: " + ex.getMessage());
            throw new RuntimeException("Failed to get all doctors", ex);
        }
    }

    // update the doctors
    public Doctor updateDoctor(Doctor doctor) {
        try {
            for (Doctor d : doctors) {
                if (d.getId() == doctor.getId()) {
                    d.setName(doctor.getName());
                    d.setContactInfo(doctor.getContactInfo());
                    d.setAddress(doctor.getAddress());
                    d.setSpecialization(doctor.getSpecialization());
                    d.setContactDetails(doctor.getContactDetails());
                    return d;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.severe("Error updating doctor: " + ex.getMessage());
            throw new RuntimeException("Failed to update doctor", ex);
        }
    }
    
    // delete the doctors using id

    public boolean deleteDoctor(int id) {
        try {
            for (Doctor doctor : doctors) {
                if (doctor.getId() == id) {
                    doctors.remove(doctor);
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            LOGGER.severe("Error deleting doctor: " + ex.getMessage());
            throw new RuntimeException("Failed to delete doctor", ex);
        }
    }
}


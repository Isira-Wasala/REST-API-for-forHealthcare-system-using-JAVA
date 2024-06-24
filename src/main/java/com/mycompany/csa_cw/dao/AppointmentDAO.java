/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;

import com.mycompany.csa_cw.classes.Appointment;
import com.mycompany.csa_cw.classes.Doctor;
import com.mycompany.csa_cw.classes.Patient;


/**
 *
 * @author HP
 */


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AppointmentDAO {
    private static final Logger LOGGER = Logger.getLogger(AppointmentDAO.class.getName());
    private static List<Appointment> appointments = new ArrayList<>();

    
    static {
        // initialized the patient, doctor and appointment details
        Patient patient01 = new Patient(1, "Isira Wasala", "0761232009", "Battaramulla, CMB", "Last checked : 2024/01/05", "Good");
        Patient patient02 = new Patient(2, "Sahan Vimukthi", "0761234567", "Dope, Bentota", "Last checked : 2024/05/01", "Good");
        Patient patient03 = new Patient(3, "Kamal Perera", "0705729587", "Madampe, Chilaw", "Last checked : 2024/04/15", "Good");

        Doctor doctor01 = new Doctor(1, "Dr. Udam Wasala", "0765697856", "Chilaw, Chilaw", "Cardiologist", "udam.api@gmail.com");
        Doctor doctor02 = new Doctor(2, "Dr. Vimukthi Dharmarathne", "0762359874", "5th rd, Chilaw", "Pediatrician", "vimukthi.api@gmail.com");
        Doctor doctor03 = new Doctor(3, "Dr. Nimal Perera", "0712365980", "10th rd, battaramulla", "Dermatologist", "nimal.api@gmail.com");

        
        appointments.add(new Appointment(1, "2024/05/25", "10.30 AM", patient01, doctor01));
        appointments.add(new Appointment(2, "2024/06/03", "14.00 PM", patient02, doctor02));
        appointments.add(new Appointment(3, "2024/07/15", "11.00 AM", patient03, doctor03));
    }

    // creating appointments
    public void createAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // get all the appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // get all the appointments by id
    public Appointment getAppointmentById(int appointId) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointId) {
                return appointment;
            }
        }
        return null;
    }

    //delete the appointment by id
    
    public void updateAppointment(Appointment updatedAppoint) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getId() == updatedAppoint.getId()) {
                appointments.set(i, updatedAppoint);
                System.out.println("Appointment is updated: " + updatedAppoint);
                LOGGER.info("Appointment is updated.");
               return;
            }
        }

        LOGGER.severe("There is no appointment with this id to update: " + updatedAppoint.getId());
        throw new RuntimeException("There is no appointment with this id to update: " + updatedAppoint.getId());
    }

    public void deleteAppointment(int appointId) {
        appointments.removeIf(appointment -> appointment.getId() == appointId);
        LOGGER.info("Appointment is deleted.");
    }
}




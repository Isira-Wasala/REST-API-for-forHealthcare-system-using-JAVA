/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;

import com.mycompany.csa_cw.classes.Patient;
import com.mycompany.csa_cw.classes.Prescription;


/**
 *
 * @author HP
 */


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PrescriptionDAO {
    
    private static final Logger LOGGER = Logger.getLogger(PrescriptionDAO.class.getName());
    
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    // initialized the patiens
    static{
        Patient patient01 = new Patient(1, "Isira Wasala", "0761232009", "Battaramulla, CMB", "Last checked : 2024/01/05", "Successfully Recovered !");
        Patient patient02 = new Patient(2, "Sahan Vimukthi", "0761234567", "Dope, Bentota", "Last checked : 2024/05/01", "Getting Recovered !");
        Patient patient03 = new Patient(3, "Kamal Perera", "0705729587", "Madampe, Chilaw", "Last checked : 2024/04/15", "Needs to attend clinics once a month !");
   
        
        prescriptions.add(new Prescription(1, "75mg", "Before having dinner ", 7, patient01));
        prescriptions.add(new Prescription(2, "100mg", "Before having breakfast", 7, patient02));
        prescriptions.add(new Prescription(3, "200mg", "Before having lunch", 7, patient03));
  
    }
    
    
    // creating prescription
    public void createPrescription(Prescription prescript){
        prescriptions.add(prescript);
    }
    
   
    public List<Prescription> getAllPrescriptions(){
        return prescriptions;
    }
    
    //get each prescription
    public Prescription getPrescriptionById(int prescriptionId){
        for(Prescription prescript : prescriptions){
            if(prescript.getId() == prescriptionId){
                return prescript;
            }
        }
        return null;
    }
    
    //Update the prescrition when recieved
    public void updatePrescription(Prescription updatedPrescript){
        for(int i = 0; i < prescriptions.size(); i++){
            Prescription prescript = prescriptions.get(i);
            if(prescript.getId() == updatedPrescript.getId()){
                prescriptions.set(i, updatedPrescript);
                System.out.println("Prescripton is updated : " + updatedPrescript);
                LOGGER.info("Prescription is updated !");
                return;
            }
        }
        LOGGER.severe("There is no ID matching with prescriptions " + updatedPrescript.getId());
        throw new RuntimeException("There is no ID matching with prescriptions " + updatedPrescript.getId());
    }
    
    //Delete prescription
    public void deletePrescription(int prescriptId){
        prescriptions.removeIf(prescription -> prescription.getId() == prescriptId);
        LOGGER.info("Prescription is deleted !");
    }

}
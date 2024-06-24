/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;

import com.mycompany.csa_cw.classes.MedicalRecord;


/**
 *
 * @author HP
 */



import java.util.ArrayList;

public class MedicalRecordDAO {
    private static ArrayList<MedicalRecord> medicalRecords;

    static {
        // initializing patients and details
        medicalRecords = new ArrayList<>();
        medicalRecords.add(new MedicalRecord(1, "Isira Wasala", "Fever", "Taking anti-biotics"));
        medicalRecords.add(new MedicalRecord(2, "Sahan Vimukthi", "Fractured", "Attended the operation"));
        medicalRecords.add(new MedicalRecord(3, "Kamal Perera", "Cough", "Using pills"));
    }

    // getting all the records 
    public ArrayList<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    // get the medical records
    public MedicalRecord getMedicalRecord(int id) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    // updating the medical records
    public boolean updateMedicalRecord(MedicalRecord medicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getId() == medicalRecord.getId()) {
                medicalRecords.set(i, medicalRecord);
                return true;
            }
        }
        return false;
    }

    // delete the medical records using id
    public boolean deleteMedicalRecord(int id) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getId() == id) {
                medicalRecords.remove(i);
                return true;
            }
        }
        return false;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;



/**
 *
 * @author HP
 */






import com.mycompany.csa_cw.classes.Billing;
import java.util.ArrayList;

public class BillingDAO {
    private static ArrayList<Billing> billings;

    // initialized the billing details + patients
    static {
        billings = new ArrayList<>();
        Billing billing1 = new Billing(1, "Isira Wasala", 1000.0, "2024/03/15");
        Billing billing2 = new Billing(2, "Sahan Vimukthi", 2500.0, "2024/04/27");
        Billing billing3 = new Billing(3, "Kamal Perera", 3000.0, "2024/05/05");
        billings.add(billing1);
        billings.add(billing2);
        billings.add(billing3);
    }

    public BillingDAO() {
    }

    // creating bills
    public Billing createBilling(Billing billing) {
        billings.add(billing);
        return billing;
    }

    // getting the bills
    public Billing getBilling(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                return billing;
            }
        }
        return null;
    }

    
    public ArrayList<Billing> getAllBillings() {
        return billings;
    }

    // updating the billins as needed
    public Billing updateBilling(Billing billing) {
        for (Billing b : billings) {
            if (b.getId() == billing.getId()) {
                b.setAmount(billing.getAmount());
                b.setPaymentDate(billing.getPaymentDate());
                b.setPatient(billing.getPatient());
                return b;
            }
        }
        return null;
    }

    // deleting the billing using id
    public boolean deleteBilling(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                billings.remove(billing);
                return true;
            }
        }
        return false;
    }
}
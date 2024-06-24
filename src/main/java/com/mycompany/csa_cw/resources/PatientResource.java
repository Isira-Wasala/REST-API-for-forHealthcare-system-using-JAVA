/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

/**
 *
 * @author HP
 */


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;



import com.mycompany.csa_cw.classes.Patient;
import com.mycompany.csa_cw.dao.PatientDAO;
import com.mycompany.csa_cw.exception.UserNotFoundException;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// initialize the start point
@Path("/patients")
public class PatientResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientResource.class);
    private final PatientDAO patientDAO = new PatientDAO();

    // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    // initialized the end point to get selected patient
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam("id") int id) {
        Patient patient = patientDAO.getPatient(id);
        if (patient != null){
            LOGGER.info("The patien is added by id : " +id);
            return patient;
        }else{
            throw new UserNotFoundException("The patiend ID is not found : " +id);
        }
    }

    // initialized the endpoint to create a new patient 
   
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPatient(Patient patient) {
        patientDAO.createPatient(patient);
    }

    // initialized the endpoint to update the existing patient
    
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        updatedPatient.setId(id);
        patientDAO.updatePatient(updatedPatient);
    }
    
    
// initialized the end point to delete the selected id
    
    @DELETE
    @Path("/delete/{id}")
    public void deletePatient(@PathParam("id") int id) {
        patientDAO.deletePatient(id);
    }
}
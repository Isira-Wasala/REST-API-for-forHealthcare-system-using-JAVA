/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

/**
 *
 * @author HP
 */


import com.mycompany.csa_cw.classes.Prescription;
import com.mycompany.csa_cw.dao.PrescriptionDAO;
import com.mycompany.csa_cw.exception.UserNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


// initialize the start point
@Path("/prescriptions")
public class PrescriptionResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionResource.class);
    
    private PrescriptionDAO prescriptDAO = new PrescriptionDAO();
    
    // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptDAO.getAllPrescriptions();
    }

    // initialized the end point to get selected prescription
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("id") int id) {
        
        Prescription presObj = prescriptDAO.getPrescriptionById(id);
        if(presObj != null){
            LOGGER.info("Getting prescription by Id wise : ", id);
            return presObj;
        }else{
            throw new UserNotFoundException("The prescription Id is not found : " + id);
        } 
    }

    // initialized the endpoint to create a new prescription
   
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrescription(Prescription prescription) {
        prescriptDAO.createPrescription(prescription);
    }
    
    // initialized the endpoint to update the existing prescription
    
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePrescription(@PathParam("id") int id, Prescription prescription) {
        Prescription currentPrescription = prescriptDAO.getPrescriptionById(id);

        if (currentPrescription != null) {
            prescription.setId(id);
            prescriptDAO.updatePrescription(prescription);
        }
    }

    // initialized the end point to delete the selected id

    @DELETE
@Path("/delete/{id}")
public void deletePrescription(@PathParam("id") int id) {
    prescriptDAO.deletePrescription(id);
}
    
    
}
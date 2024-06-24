/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

/**
 *
 * @author HP
 */

import com.mycompany.csa_cw.classes.Doctor;
import com.mycompany.csa_cw.dao.DoctorDAO;
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


import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// initialize the start point
@Path("/doctors")
public class DoctorResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorResource.class);
    private final DoctorDAO doctorDAO = new DoctorDAO();

    // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    // initialized the end point to get selected doctor
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctor(@PathParam("id") int id) {
        Doctor doctor = doctorDAO.getDoctor(id);
        if (doctor != null){
            LOGGER.info("The doctor is added by id : " +id);
            return doctor;
        }else{
            throw new UserNotFoundException ("The doctor ID is not found : " +id);
        }
    }

    // initialized the endpoint to create a new doctor
    
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDoctor(Doctor doctor) {
        doctorDAO.createDoctor(doctor);
    }
    

   
    // initialized the endpoint to update the existing doctor
   
        
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDoctor(@PathParam("id") int id, Doctor doctor) {
        doctor.setId(id);
        doctorDAO.updateDoctor(doctor);
    }
    
    
    
    // initialized the end point to delete the selected id
    @DELETE
    @Path("/delete/{id}")
    public void deleteDoctor(@PathParam("id") int id) {
        doctorDAO.deleteDoctor(id);
    }
}
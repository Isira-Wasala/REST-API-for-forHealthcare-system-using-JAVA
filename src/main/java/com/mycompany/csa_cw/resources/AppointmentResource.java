/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

/**
 *
 * @author HP
 */

import com.mycompany.csa_cw.classes.Appointment;
import com.mycompany.csa_cw.dao.AppointmentDAO;
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
@Path("/appointments")
public class AppointmentResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentResource.class);
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    // initialized the end point to get selected appointment
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointment(@PathParam("id") int id) {
        Appointment appointment = appointmentDAO.getAppointmentById(id);
        if (appointment != null){
            LOGGER.info("The appointment is added by id : " +id);
            return appointment;
        }else{
            throw new UserNotFoundException("The Appointment id is not found : "+id);
        }

    }

    // initialized the endpoint to create a new appointment
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAppointment(Appointment appointment) {
        appointmentDAO.createAppointment(appointment);
    }

    // initialized the endpoint to update the existing appoitment
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAppointment(@PathParam("id") int id, Appointment appointment) {
        appointment.setId(id);
        appointmentDAO.updateAppointment(appointment);
    }

    // initialized the end point to delete the selected id
    @DELETE
    @Path("/delete/{id}")
    public void deleteAppointment(@PathParam("id") int id) {
        appointmentDAO.deleteAppointment(id);
    }
}
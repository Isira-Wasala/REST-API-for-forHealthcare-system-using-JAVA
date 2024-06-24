/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

/**
 *
 * @author HP
 */

import com.mycompany.csa_cw.classes.Billing;
import com.mycompany.csa_cw.dao.BillingDAO;
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
@Path("/billings")
public class BillingResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingResource.class);
    private BillingDAO billingDAO = new BillingDAO();

    // initialized the endpoint to create a new bill
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBilling(Billing billing) {
        
        billingDAO.createBilling(billing);
    }

     // initialized the endpoint to update the existing bill
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBilling(@PathParam("id") int id, Billing billing) {
        billing.setId(id);
        billingDAO.updateBilling(billing);
    }

    // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBillings() {
        return billingDAO.getAllBillings();
    }

    // initialized the end point to get selected billings
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBilling(@PathParam("id") int id) {
        Billing billing = billingDAO.getBilling(id);
        if(billing != null){
            LOGGER.info("The Billing is added by id : " +id);
            return billing;
        }else{
            throw new UserNotFoundException("The Billing ID is not found :" +id);
        }

    }

    // initialized the end point to delete the selected id
    @DELETE
    @Path("/delete/{id}")
    public void deleteBilling(@PathParam("id") int id) {
        billingDAO.deleteBilling(id);
    }
}
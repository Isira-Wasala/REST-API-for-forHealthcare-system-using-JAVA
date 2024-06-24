/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

import com.mycompany.csa_cw.classes.Person;
import com.mycompany.csa_cw.dao.PersonDAO;
import com.mycompany.csa_cw.exception.UserNotFoundException;


import java.util.List;

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

/**
 *
 * @author HP
 */


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// initialize the start point
@Path("/persons")
public class PersonResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);
    
    private final PersonDAO personDAO = new PersonDAO();

        // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    // initialized the end point to get selected person
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") int id) {
        Person person = personDAO.getPerson(id);
        if (person != null){
            LOGGER.info("The person is added by ID : " +id);
            return person;
        }else{
            throw new UserNotFoundException("The id is not founded : " +id);
        }
    }

    // initialized the endpoint to create a new person
   
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(Person person) {
        personDAO.createPerson(person);
    }

    // initialized the endpoint to update the existing person
    
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("id") int id, Person updatedPerson) {
        Person existingPerson = personDAO.getPerson(id);
        if (existingPerson != null) {
            updatedPerson.setId(id);
            personDAO.updatePerson(updatedPerson);
        }
    }

    // initialized the end point to delete the selected id

    @DELETE
    @Path("/delete/{id}")
    public void deletePerson(@PathParam("id") int id) {
        personDAO.deletePerson(id);
    }
}
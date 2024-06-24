/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.resources;

/**
 *
 * @author HP
 */


import com.mycompany.csa_cw.classes.MedicalRecord;
import com.mycompany.csa_cw.dao.MedicalRecordDAO;
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
@Path("/medicalrecords")
public class MedicalRecordResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordResource.class);
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    // initialized the end point to get all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }

    // initialized the end point to get selected medical records
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordById(@PathParam("id") int id) {
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecord(id);
        if (medicalRecord != null){
            LOGGER.info("The Medical Record is added by id : " +id);
            return medicalRecord;
        }else{
            throw new UserNotFoundException ("The Medical Record Id is not found : " +id);
        }
    }

    // initialized the endpoint to create a new medical record
    @POST
    @Path("/create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
    }

    // initialized the endpoint to update the existing medical record
   
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMedicalRecord(@PathParam("id") int id, MedicalRecord updatedMedicalRecord) {
        MedicalRecord existingMedicalRecord = medicalRecordDAO.getMedicalRecord(id);
        if (existingMedicalRecord != null) {
            updatedMedicalRecord.setId(id);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
        }
    }

    // initialized the end point to delete the selected id
    @DELETE
    @Path("/delete/{id}")
    public void deleteMedicalRecord(@PathParam("id") int id) {
        medicalRecordDAO.deleteMedicalRecord(id);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csa_cw.dao;


/**
 *
 * @author HP
 */



import com.mycompany.csa_cw.classes.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonDAO {
    private static final Logger LOGGER = Logger.getLogger(PersonDAO.class.getName());
    private static List<Person> persons;

    // initialized the patients
    static {
        persons = new ArrayList<>();
        persons.add(new Person(1, "Isira Wasala", "isira.api@gmail.com", "Battaramulla, CMB"));
        persons.add(new Person(2, "Sahan Vimukthi", "sahan.api@gmail.com", "Dope, Bentota"));
        persons.add(new Person(3, "Kamal Perera", "kamal.api@gmail.com", "Madampe, Chilaw"));
        persons.add(new Person(4, "Dr. Udam Wasala", "udam.api@gmail.com", "Chilaw, Chilaw"));
        persons.add(new Person(5, "Dr. Vimukthi Dharmarathne", "vimukthi.api@gmail.com", "5th rd, Chilaw"));
        persons.add(new Person(6, "Dr. Nimal Perera", "nimal.api@gmail.com", "10th rd, battaramulla"));
    }

    // default constructor
    public PersonDAO() {
        
    }

    // creating the persons as needed
    public Person createPerson(Person person) {
        try {
            persons.add(person);
            LOGGER.info("Person created: " + person.getId());
            return person;
        } catch (Exception ex) {
            LOGGER.severe("Error creating person: " + ex.getMessage());
            throw new RuntimeException("Failed to create person", ex);
        }
    }

    // getting the person
    public Person getPerson(int id) {
        try {
            for (Person person : persons) {
                if (person.getId() == id) {
                    return person;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.severe("Error getting person: " + ex.getMessage());
            throw new RuntimeException("Failed to get person", ex);
        }
    }

    // getting all the persons at once
    public List<Person> getAllPersons() {
        try {
            return persons;
        } catch (Exception ex) {
            LOGGER.severe("Error getting all persons: " + ex.getMessage());
            throw new RuntimeException("Failed to get all persons", ex);
        }
    }

    // delete the person 
    public Person updatePerson(Person person) {
        try {
            for (Person p : persons) {
                if (p.getId() == person.getId()) {
                    p.setName(person.getName());
                    p.setContactInfo(person.getContactInfo());
                    p.setAddress(person.getAddress());
                    return p;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.severe("Error updating person: " + ex.getMessage());
            throw new RuntimeException("Failed to update person", ex);
        }
    }

    public boolean deletePerson(int id) {
        try {
            for (Person person : persons) {
                if (person.getId() == id) {
                    persons.remove(person);
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            LOGGER.severe("Error deleting person: " + ex.getMessage());
            throw new RuntimeException("Failed to delete person", ex);
        }
    }
}
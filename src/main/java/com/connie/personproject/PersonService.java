package com.connie.personproject;

import java.util.List;
import java.util.Optional;

public class PersonService {
    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    } //initiate DAO using constructor

    public void savePerson(Person person) {
        if (person.getAge() == null ||
                person.getId() == null ||
                person.getName().length() == 0) { //if any of these conditions are met, exception will be thrown
            throw new IllegalStateException("Person cannot have empty fields");
        }
//creating boolean variable to state whether person with specific id exists
        boolean exists = doesPersonWithIdExists(person.getId());

        //throws exception if id is already in use(person exists)
        if (exists) {
            throw new IllegalStateException("person with id " + person.getId() + " already exists");
        }
        //if person doesn't exist, calls on DAO and uses method to save person from access layer
        personDAO.savePerson(person);
    }

    public void deletePerson(int id) {
        boolean exists = doesPersonWithIdExists(id);
        if (!exists) { //checks if person exists. if they don't then exception thrown.
            throw new IllegalStateException("person with id " + id + " not found");
        }
        personDAO.deletePerson(id); //deletes person by ID because it is unique to each person.
    }

    //method to get all people in the list
    public List<Person> getPeople() {
        return personDAO.getPeople();
    }

    //method to get person by searching specific id
    public Optional<Person> getPersonById(int id) {
        return personDAO
                .getPeople()
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    private boolean doesPersonWithIdExists(Integer id) {
        return personDAO
                .getPeople()
                .stream()
                .anyMatch(p -> p.getId().equals(id));
    }
}

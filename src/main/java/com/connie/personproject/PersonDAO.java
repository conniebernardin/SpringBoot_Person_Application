package com.connie.personproject;
import java.util.List;

//create interface person DAO with all methods
//all abstract methods with no body.

public interface PersonDAO {
    void savePerson(Person person);
    void deletePerson(int id);
    List<Person> getPeople();
    Person getPersonById(int id);
}
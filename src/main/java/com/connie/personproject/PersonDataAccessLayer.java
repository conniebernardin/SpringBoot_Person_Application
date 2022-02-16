package com.connie.personproject;


import java.util.ArrayList;
import java.util.List;

//personDataAccessLayer implements personDAO service, meaning it implements every method from DAO interface.

public class PersonDataAccessLayer implements PersonDAO{

    List<Person> people = new ArrayList<>();

    @Override
    public void savePerson(Person person) {
    this.people.add(person); //using list method .add to save person to arraylist called 'people'
    }

    @Override
    public void deletePerson(int id) {
        people.remove(getPersonById(id));
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Person getPersonById(int id) {
        for (Person p: people
             ) {
            if (p.getId() == id){
                return p;
            }
        }return null;
    }
}

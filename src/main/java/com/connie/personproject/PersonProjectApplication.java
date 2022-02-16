package com.connie.personproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonProjectApplication.class, args);

		Person connie = new Person("Connie", 22, 1);
		Person alimaa = new Person("Alimaa", 22, 2);
		Person suraya = new Person("Suraya", 24, 3);
		Person robyn = new Person("Robyn", 23, 4);

		PersonDAO personDAO = new PersonDataAccessLayer(); 	//general DAO currently equal to AccessLayer/implementation of DAO because that is where list is stored.
															// Can be changed to SQL database or file for example.

		PersonService personServiceInstance = new PersonService(personDAO); //call person service as that is where business logic is happening.
																			// want to run checks in business logic before adding person to DAO.
		personServiceInstance.savePerson(connie);
		personServiceInstance.savePerson(alimaa);
		personServiceInstance.savePerson(suraya);
		personServiceInstance.savePerson(robyn);
	}
}


package two.service;

import two.PersonRepository;
import two.model.Person;

import java.util.Date;
import java.util.Scanner;

public class PersonService {
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person signUp(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return personRepository.save(person);
    }
}

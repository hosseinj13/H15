package two.service;

import two.PersonRepository;
import two.model.Person;

import javax.xml.crypto.Data;
import java.util.Date;


public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person signUp(String firstName, String lastName, Date dateOfBirth) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(dateOfBirth);
        return personRepository.save(person);
    }
}

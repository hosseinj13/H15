package two.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import two.PersonRepository;
import two.model.Person;
import java.util.Date;
import java.util.Set;


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

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Person> violation : violations) {
                System.out.println("Property: " + violation.getPropertyPath() +
                        ", Invalid Value: " + violation.getInvalidValue() +
                        ", Message: " + violation.getMessage());
            }
            System.out.println("Sign up failed due to validation errors.");
            return null;
        }

        return personRepository.save(person);
    }
}

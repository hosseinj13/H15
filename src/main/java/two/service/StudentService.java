package two.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import two.model.Student;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;


public class StudentService {
    private final Session session;
    private final Scanner scanner = new Scanner(System.in);


    public StudentService(Session session) {
        this.session = session;
    }

    public Student signUp(String firstName, String lastName, Date birthDate, String studentCode, String fieldOfStudy, int entranceYear) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(birthDate);
        student.setStudentCode(studentCode);
        student.setFieldOfStudy(fieldOfStudy);
        student.setEntranceYear(entranceYear);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Student> violation : violations) {
                System.out.println(violation.getMessage());
            }
            System.out.println("Sign up failed due to validation errors.");
            return null;
        }


        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();

        return student;
    }
}

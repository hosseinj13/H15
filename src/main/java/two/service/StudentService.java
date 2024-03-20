package two.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import two.model.Person;
import two.model.Student;

import java.util.Date;
import java.util.Scanner;

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

        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();

        return student;
    }
}

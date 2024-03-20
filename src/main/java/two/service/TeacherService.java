package two.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import two.model.Teacher;
import two.model.TeacherRank;

import java.util.Date;
import java.util.Set;

public class TeacherService {
    private final Session session;

    public TeacherService(Session session) {
        this.session = session;
    }

    public Teacher signUp(String firstName, String lastName, Date birthDate, String teacherCode, TeacherRank teacherRank, double monthlySalary) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setDateOfBirth(birthDate);
        teacher.setTeacherCode(teacherCode);
        teacher.setTeacherRank(teacherRank);
        teacher.setMonthlySalary(monthlySalary);


        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Teacher> violation : violations) {
                System.out.println(violation.getMessage());
            }
            System.out.println("Sign up failed due to validation errors.");
            return null;
        }


        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();

        return teacher;
    }
}


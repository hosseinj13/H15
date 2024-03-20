package two.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import two.model.Teacher;
import two.model.TeacherRank;

import java.util.Date;

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

        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();

        return teacher;
    }
}


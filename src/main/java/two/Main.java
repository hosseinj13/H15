package two;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import two.model.Person;
import two.model.Student;
import two.model.Teacher;
import two.model.TeacherRank;
import two.service.PersonService;
import two.service.StudentService;
import two.service.TeacherService;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Session session;

    public static void main(String[] args) {
        session = openSession();

        displayMenu();

        session.close();
    }

    private static Session openSession() {

        StandardServiceRegistry build = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(build)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .buildMetadata()
                .buildSessionFactory();

        return sessionFactory.openSession();
    }


    public static void displayMenu() {

        int choice;

        do {
            System.out.println("*****WELCOME TO SIGNUP MENU*****");
            System.out.println("1. Sign up as Person");
            System.out.println("2. Sign up as Student");
            System.out.println("3. Sign up as Teacher");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signUpPerson(session);
                case 2:
                    signUpStudent(session);
                    break;
                case 3:
                    signUpTeacher(session);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 3);

        scanner.close();
    }


    private static void signUpPerson(Session session) {
        System.out.println("Enter person's first name: ");
        String firstName = scanner.next();

        System.out.println("Enter person's last name: ");
        String lastName = scanner.next();

        System.out.println("Enter person's birth date (YYYY-MM-DD): ");
        String birthDateString = scanner.next();
        Date birthDate = parseDate(birthDateString);

        PersonService personService = new PersonService(new PersonRepository(session));
        Person person = personService.signUp(firstName, lastName, birthDate);
        System.out.println("Signed up successfully. Person ID is: " + person.getId());
    }

    private static void signUpStudent(Session session) {
        System.out.println("Enter student's first name: ");
        String firstName = scanner.next();

        System.out.println("Enter student's last name: ");
        String lastName = scanner.next();

        System.out.println("Enter student's birth date (YYYY-MM-DD): ");
        String birthDateString = scanner.next();
        Date birthDate = parseDate(birthDateString);

        System.out.println("Enter student's student code: ");
        String studentCode = scanner.next();

        System.out.println("Enter student's field of study: ");
        String fieldOfStudy = scanner.next();

        System.out.println("Enter student's entrance year: ");
        int entranceYear = scanner.nextInt();


        StudentService studentService = new StudentService(session);
        Student student = studentService.signUp(firstName, lastName, birthDate, studentCode, fieldOfStudy, entranceYear);
        System.out.println("Signed up successfully. Student ID is: " + student.getId());
    }

    private static void signUpTeacher(Session session) {
        System.out.println("Enter teacher's first name: ");
        String firstName = scanner.next();

        System.out.println("Enter teacher's last name: ");
        String lastName = scanner.next();

        System.out.println("Enter teacher's birth date (YYYY-MM-DD): ");
        String birthDateString = scanner.next();
        Date birthDate = parseDate(birthDateString);

        System.out.println("Enter teacher's code: ");
        String teacherCode = scanner.next();

        System.out.println("Enter teacher's academic rank: ");
        TeacherRank teacherRank = TeacherRank.valueOf(scanner.next());

        System.out.println("Enter teacher's monthly salary: ");
        double monthlySalary = scanner.nextDouble();

        TeacherService teacherService = new TeacherService(session);
        Teacher teacher = teacherService.signUp(firstName, lastName, birthDate, teacherCode, teacherRank, monthlySalary);
        System.out.println("Signed up successfully. Teacher ID is: " + teacher.getId());
    }

    private static Date parseDate(String dateString) {
        return new Date();
    }
}

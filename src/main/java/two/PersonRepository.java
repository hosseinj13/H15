package two;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import two.model.Person;
import java.util.List;

public class PersonRepository {
    private final Session session;

    public PersonRepository(Session session) {
        this.session = session;
    }

    public Person save(Person person) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
            return person;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public void update(Person person) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Person person) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Person> loadAll() {
        Transaction transaction = null;
        List<Person> people = null;
        try {
            transaction = session.beginTransaction();
            people = session.createQuery("from Person", Person.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return people;
    }

    public boolean contains(Person person) {
        Transaction transaction = null;
        boolean contains = false;
        try {
            transaction = session.beginTransaction();
            Query<Person> query = session.createQuery("from Person where id = :id", Person.class);
            query.setParameter("id", person.getId());
            contains = query.uniqueResult() != null;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return contains;
    }
}

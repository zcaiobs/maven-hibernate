package repository;

import model.person.Person;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonPersistence implements PersistenceRepository<Person>{

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("City-PU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public Person findById(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Person person) {
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void remove(Person person) {
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        entityManager.getTransaction().commit();
    }
}

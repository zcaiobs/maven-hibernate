package repository;

import model.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VehiclePersistence implements PersistenceRepository<Vehicle> {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("City-PU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<Vehicle> findAll() {
        return entityManager.createQuery("select v from Vehicle v", Vehicle.class).getResultList();
    }

    @Override
    public Vehicle findById(Integer id) {
        return entityManager.find(Vehicle.class, id);
    }

    @Override
    public void save(Vehicle vehicle) {
        entityManager.getTransaction().begin();
        entityManager.persist(vehicle);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Vehicle vehicle) {
        entityManager.getTransaction().begin();
        entityManager.merge(vehicle);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void remove(Vehicle v) {
        entityManager.getTransaction().begin();
        entityManager.remove(v);
        entityManager.getTransaction().commit();
    }
}

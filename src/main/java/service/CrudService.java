package service;

import repository.PersistenceRepository;
import java.util.List;

public class CrudService<T> {

    private final PersistenceRepository<T> persistenceRepository;

    public CrudService(PersistenceRepository<T> persistenceRepository) {
        this.persistenceRepository = persistenceRepository;
    }

    public List<T> findAll() {
       return persistenceRepository.findAll();
    }

    public void save(T t) {
        persistenceRepository.save(t);
    }

    public T findById(Integer id) {
        return persistenceRepository.findById(id);
    }

    public void update(T t) {
        persistenceRepository.update(t);
    }

    public void close() { persistenceRepository.close(); }

    public void remove(T t) {
        persistenceRepository.remove(t);
    }
}

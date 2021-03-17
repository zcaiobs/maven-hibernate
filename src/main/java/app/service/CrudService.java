package app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import app.repository.PersistenceRepository;

@Service
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

    public boolean remove(T t) {
        return persistenceRepository.remove(t);
    }
}

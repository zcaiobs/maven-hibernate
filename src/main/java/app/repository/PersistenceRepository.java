package app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PersistenceRepository<T>{
    List<T> findAll();
    T findById(Integer id);
    void save(T t);
    void update(T t);
    void close();
    boolean remove(T t);
}

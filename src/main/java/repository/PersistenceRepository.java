package repository;

import java.util.List;

public interface PersistenceRepository<T>{
    List<T> findAll();
    T findById(Integer id);
    void save(T t);
    void update(T t);
    void close();
    void remove(T t);
}

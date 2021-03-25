package net.idao;

import java.util.List;
import java.util.Optional;

public interface IDaoBase<T> {
    T getById(Integer id);
    void add(T t);
    T update(T t);
    void delete(Integer id);
    List<T> getAll();
}
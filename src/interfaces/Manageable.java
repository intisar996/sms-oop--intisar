package interfaces;

public interface Manageable<T> {

    void add(T entity);
    Boolean update(Long id);


}

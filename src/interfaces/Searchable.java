package interfaces;

public interface Searchable {

    Object searchById(Long id);

    Object[] search(Long keyword);

}

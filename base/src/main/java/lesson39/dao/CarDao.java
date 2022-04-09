package lesson39.dao;

public interface CarDao {

    Car findByName(String name);
    String getName();
}

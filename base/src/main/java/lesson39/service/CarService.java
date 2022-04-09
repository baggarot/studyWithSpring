package lesson39.service;

import lesson39.dao.Car;

public interface CarService {

    Car getByName(String name);
    String getName();
}

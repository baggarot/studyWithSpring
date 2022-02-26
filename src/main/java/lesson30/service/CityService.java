package lesson30.service;

import lesson30.model.City;

import java.util.List;

public interface CityService {

    City add(City city);
    void delete(City city);
    List<City> allCities();
}

package lesson39.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    private Car car;

    @Override
    public Car findByName(String name) {
        return this.car = new Car(name);
    }

    @Override
    public String getName() {
        return this.car == null ? null : this.car.getModel();
    }
}

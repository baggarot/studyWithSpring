package lesson39.service;

import lesson39.dao.Car;
import lesson39.dao.CarDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Override
    public Car getByName(String name) {
        return this.carDao.findByName(name);
    }

    @Override
    public String getName() {
        return this.carDao.getName();
    }
}

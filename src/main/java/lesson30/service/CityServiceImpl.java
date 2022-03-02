package lesson30.service;

import lesson30.model.City;
import lesson30.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    @Transactional(noRollbackFor = IllegalStateException.class)
    public City add(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> allCities() {
        return cityRepository.findAll();
    }
}

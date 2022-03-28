package lesson30.service;

import lesson30.model.City;
import lesson35.dto.CityDto;
import lesson35.dto.CityPageDto;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface CityService {

    City add(City city);
    void delete(City city);
    List<City> allCities();

    Optional<CityDto> getByCityId(Long cityId);

    void deleteById(Long cityId);

    CityPageDto getPage(Pageable pageable);

    CityDto save(@Valid CityDto city);
}

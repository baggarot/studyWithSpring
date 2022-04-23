package lesson43.service;

import lesson43.dto.CityDto;
import lesson43.dto.CityPageDto;
import lesson43.model.City;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface CityService {

    List<CityDto> findAll();
    CityPageDto getPage(Pageable pageable);
    Optional<CityDto> getByCode(@NotNull long cityCode);
    CityDto save(@Valid CityDto city);
    void deleteByCode(@NotNull long cityCode);
    void delete(@Valid City city);
}

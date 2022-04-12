package lesson40.service;

import lesson40.dto.CityDto;
import lesson40.dto.CityPageDto;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface CityService {

    List<CityDto> findAll();
    CityPageDto getPage(Pageable pageable);
    Optional<CityDto> getByCode(@NotEmpty String cityCode);
    CityDto save(@Valid CityDto city);
    void deleteByCode(@NotEmpty String cityCode);
    void delete(@Valid CityDto city);
}

package lesson30.service;

import lesson30.model.City;
import lesson30.repository.CityRepository;
import lesson35.dto.CityDto;
import lesson35.dto.CityPageDto;
import lesson35.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

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

    @Override
    @Transactional(readOnly = true)
    public Optional<CityDto> getByCityId(@NotEmpty Long cityId) {
        return cityMapper.toOptionalDto(cityRepository.findById(cityId));
    }

    @Override
    @Transactional
    public void deleteById(@NotEmpty Long cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public CityPageDto getPage(Pageable pageable) {
        Page<City> currentPage = cityRepository.findAll(pageable);
        return new CityPageDto(cityMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional
    public CityDto save(@Valid CityDto city) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(city)));
    }
}

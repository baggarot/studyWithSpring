package lesson40.service;

import lesson40.dto.CityDto;
import lesson40.dto.CityPageDto;
import lesson40.mapper.CityMapper;
import lesson40.model.City;
import lesson40.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@ConditionalOnProperty(value = "application.nosql.type", havingValue = "mongo", matchIfMissing = true)
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        return cityMapper.toDtos(cityRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public CityPageDto getPage(Pageable pageable) {
        Page<City> currentPage = cityRepository.findAll(pageable);
        return new CityPageDto(cityMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CityDto> getByCode(@NotEmpty String cityCode) {
        return cityMapper.toOptionalDto(cityRepository.findById(cityCode));
    }

    @Override
    @Transactional
    public CityDto save(@Valid CityDto city) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(city)));
    }

    @Override
    @Transactional
    public void deleteByCode(@NotEmpty String cityCode) {
        cityRepository.deleteById(cityCode);
    }

    @Override
    @Transactional
    public void delete(@Valid CityDto city) {
        cityRepository.delete(cityMapper.toEntity(city));
    }
}

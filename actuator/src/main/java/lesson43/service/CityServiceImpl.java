package lesson43.service;

import lesson43.dto.CityDto;
import lesson43.dto.CityPageDto;
import lesson43.mapper.CityMapper;
import lesson43.model.City;
import lesson43.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        return cityMapper.toDtos(cityRepository.findAll());
    }

    @Override
    public CityPageDto getPage(Pageable pageable) {
        Page<City> currentPage = cityRepository.findAll(pageable);
        return new CityPageDto(cityMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious(),
                true);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CityDto> getByCode(@NotNull long cityCode) {
        return cityMapper.toOptionalDto(cityRepository.findById(cityCode));
    }

    @Override
    @Transactional
    public CityDto save(@Valid CityDto city) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(city)));
    }

    @Override
    @Transactional
    public void deleteByCode(@NotNull long cityCode) {
        cityRepository.deleteById(cityCode);
    }

    @Override
    @Transactional
    public void delete(@Valid City city) {
        cityRepository.delete(city);
    }
}

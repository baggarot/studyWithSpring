package lesson40.mapper;

import lesson40.dto.CityDto;
import lesson40.model.City;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface CityMapper {

    CityDto toDto(City entity);
    City toEntity(CityDto entity);

    default List<CityDto> toDtos(List<City> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<CityDto> toOptionalDto(Optional<City> entity) {
        return entity.map(this::toDto);
    }
}

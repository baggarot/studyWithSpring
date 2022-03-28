package lesson35.mapper;

import lesson30.model.City;
import lesson35.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface CityMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "cityCode", source = "entity.cityCode")
    @Mapping(target = "cityName", source = "entity.cityName")
    @Mapping(target = "cityNameInEnglish", source = "entity.cityNameInEnglish")
    @Mapping(target = "numberOfResidents", source = "entity.numberOfResidents")
    CityDto toDto(City entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "cityCode", source = "dto.cityCode")
    @Mapping(target = "cityName", source = "dto.cityName")
    @Mapping(target = "cityNameInEnglish", source = "dto.cityNameInEnglish")
    @Mapping(target = "numberOfResidents", source = "dto.numberOfResidents")
    City toEntity(CityDto dto);

    default List<CityDto> toDtos(List<City> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<CityDto> toOptionalDto(Optional<City> entity) {
        return entity.map(this::toDto);
    }
}

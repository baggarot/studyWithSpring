package lesson43.mapper;

import lesson43.dto.CityDto;
import lesson43.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface CityMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "nameInEnglish", source = "entity.nameInEnglish")
    @Mapping(target = "numberOfResidents", source = "entity.numberOfResidents")
    CityDto toDto(City entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "nameInEnglish", source = "dto.nameInEnglish")
    @Mapping(target = "numberOfResidents", source = "dto.numberOfResidents")
    City toEntity(CityDto dto);

    default List<CityDto> toDtos(List<City> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<CityDto> toOptionalDto(Optional<City> entity) {
        return entity.map(this::toDto);
    }
}

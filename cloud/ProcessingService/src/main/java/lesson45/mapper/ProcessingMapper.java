package lesson45.mapper;

import lesson45.domain.Processing;
import lesson45.dto.ProcessingDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProcessingMapper {

    ProcessingDto toDto(Processing entity);
}

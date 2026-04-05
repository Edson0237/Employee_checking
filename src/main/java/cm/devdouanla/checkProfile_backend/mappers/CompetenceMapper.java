package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.CompetenceDto;
import cm.devdouanla.checkProfile_backend.models.Competence;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    CompetenceDto toDto(Competence competence);
    Competence toEntity(CompetenceDto competenceDto);
}
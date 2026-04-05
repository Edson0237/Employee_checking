package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.RapportConformiteDto;
import cm.devdouanla.checkProfile_backend.models.RapportConformite;

@Mapper(componentModel = "spring")
public interface RapportConformiteMapper {
    RapportConformiteDto toDto(RapportConformite rapportConformite);
    RapportConformite toEntity(RapportConformiteDto rapportConformiteDto);
}
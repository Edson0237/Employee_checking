package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.PosteDto;
import cm.devdouanla.checkProfile_backend.models.Poste;

@Mapper(componentModel = "spring")
public interface PosteMapper {
    PosteDto toDto(Poste poste);
    Poste toEntity(PosteDto posteDto);
}
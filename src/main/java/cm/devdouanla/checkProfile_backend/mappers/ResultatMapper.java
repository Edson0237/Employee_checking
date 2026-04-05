package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.ResultatDto;
import cm.devdouanla.checkProfile_backend.models.Resultat;

@Mapper(componentModel = "spring")
public interface ResultatMapper {
    ResultatDto toDto(Resultat resultat);
    Resultat toEntity(ResultatDto resultatDto);
}
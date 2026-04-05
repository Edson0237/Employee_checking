package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.ReponseCandidatDto;
import cm.devdouanla.checkProfile_backend.models.ReponseCandidat;

@Mapper(componentModel = "spring")
public interface ReponseCandidatMapper {
    ReponseCandidatDto toDto(ReponseCandidat reponseCandidat);
    ReponseCandidat toEntity(ReponseCandidatDto reponseCandidatDto);
}
package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.EvaluationDto;
import cm.devdouanla.checkProfile_backend.models.Evaluation;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {
    EvaluationDto toDto(Evaluation evaluation);
    Evaluation toEntity(EvaluationDto evaluationDto);
}
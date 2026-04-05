package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.QuestionDto;
import cm.devdouanla.checkProfile_backend.models.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDto toDto(Question question);
    Question toEntity(QuestionDto questionDto);
}
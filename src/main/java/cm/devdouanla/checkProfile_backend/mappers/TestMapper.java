package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.TestDto;
import cm.devdouanla.checkProfile_backend.models.Test;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestDto toDto(Test test);
    Test toEntity(TestDto testDto);
}
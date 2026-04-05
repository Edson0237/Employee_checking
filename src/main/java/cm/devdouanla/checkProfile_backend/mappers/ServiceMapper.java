package cm.devdouanla.checkProfile_backend.mappers;

import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.ServiceDto;
import cm.devdouanla.checkProfile_backend.models.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceDto toDto(Service service);
    Service toEntity(ServiceDto serviceDto);
}
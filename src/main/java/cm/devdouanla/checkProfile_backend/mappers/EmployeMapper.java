package cm.devdouanla.checkProfile_backend.mappers;
import org.mapstruct.Mapper;

import cm.devdouanla.checkProfile_backend.dto.EmployeDto;
import cm.devdouanla.checkProfile_backend.models.Employe;
@Mapper(componentModel = "spring")   // ← Add this
public interface EmployeMapper {
    EmployeDto toDto(Employe employe);
    Employe toEntity(EmployeDto employeDto);


}

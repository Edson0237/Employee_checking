package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.EmployeDto;
import java.util.List;

public interface EmployeService {

    EmployeDto create(EmployeDto employeDto);

    List<EmployeDto> findAll();

    Optional<EmployeDto> findById(UUID employeId);

    EmployeDto update(UUID employeId, EmployeDto employeDto);

    String deleteById(UUID employeId);

    String deleteAll();
}
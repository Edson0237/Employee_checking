package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.ServiceDto;
import java.util.List;

public interface ServiceService {

    ServiceDto create(ServiceDto serviceDto);

    List<ServiceDto> findAll();

    Optional<ServiceDto> findById(UUID serviceId);

    ServiceDto update(UUID serviceId, ServiceDto serviceDto);

    String deleteById(UUID serviceId);

    String deleteAll();
}
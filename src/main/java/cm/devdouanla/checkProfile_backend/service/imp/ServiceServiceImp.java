package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.ServiceService;
import cm.devdouanla.checkProfile_backend.dto.ServiceDto;
import cm.devdouanla.checkProfile_backend.mappers.ServiceMapper;
import cm.devdouanla.checkProfile_backend.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServiceServiceImp implements ServiceService {

    final private ServiceRepository serviceRepository;
    final private ServiceMapper serviceMapper;

    public ServiceServiceImp(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private ServiceDto save(ServiceDto serviceDto) {
        cm.devdouanla.checkProfile_backend.models.Service service = serviceMapper.toEntity(serviceDto);
        cm.devdouanla.checkProfile_backend.models.Service serviceSaved = serviceRepository.save(service);
        return serviceMapper.toDto(serviceSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public ServiceDto create(ServiceDto serviceDto) {
        return save(serviceDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<ServiceDto> findAll() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<ServiceDto> findById(UUID serviceId) {
        return serviceRepository.findById(serviceId)
                .map(service -> ServiceDto.builder()
                        .id(service.getId())
                        .nom(service.getNom())
                        .description(service.getDescription())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public ServiceDto update(UUID serviceId, ServiceDto serviceDto) {
        Optional<ServiceDto> serviceDtoOptional = findById(serviceId);

        if (serviceDtoOptional.isPresent()) {
            ServiceDto existingServiceDto = serviceDtoOptional.get();

            if (serviceDto.getNom() != null) {
                existingServiceDto.setNom(serviceDto.getNom());
            }
            if (serviceDto.getDescription() != null) {
                existingServiceDto.setDescription(serviceDto.getDescription());
            }

            if (serviceDto.getPostes() != null) {
                existingServiceDto.setPostes(serviceDto.getPostes());
            }

            return save(existingServiceDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID serviceId) {
        serviceRepository.deleteById(serviceId);
        return "Le service a été supprimé avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        serviceRepository.deleteAll();
        return "La liste des services a été supprimée avec succès";
    }
}

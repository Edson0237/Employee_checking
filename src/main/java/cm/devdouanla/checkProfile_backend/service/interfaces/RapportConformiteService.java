package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.RapportConformiteDto;
import java.util.List;

public interface RapportConformiteService {

    RapportConformiteDto create(RapportConformiteDto rapportConformiteDto);

    List<RapportConformiteDto> findAll();

    Optional<RapportConformiteDto> findById(UUID rapportConformiteId);

    RapportConformiteDto update(UUID rapportConformiteId, RapportConformiteDto rapportConformiteDto);

    String deleteById(UUID rapportConformiteId);

    String deleteAll();
}
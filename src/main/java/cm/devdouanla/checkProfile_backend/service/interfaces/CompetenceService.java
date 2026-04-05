package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.CompetenceDto;
import java.util.List;

public interface CompetenceService {

    CompetenceDto create(CompetenceDto competenceDto);

    List<CompetenceDto> findAll();

    Optional<CompetenceDto> findById(UUID competenceId);

    CompetenceDto update(UUID competenceId, CompetenceDto competenceDto);

    String deleteById(UUID competenceId);

    String deleteAll();
}
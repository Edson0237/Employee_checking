package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.ReponseCandidatDto;
import java.util.List;

public interface ReponseCandidatService {

    ReponseCandidatDto create(ReponseCandidatDto reponseCandidatDto);

    List<ReponseCandidatDto> findAll();

    Optional<ReponseCandidatDto> findById(UUID reponseCandidatId);

    ReponseCandidatDto update(UUID reponseCandidatId, ReponseCandidatDto reponseCandidatDto);

    String deleteById(UUID reponseCandidatId);

    String deleteAll();
}
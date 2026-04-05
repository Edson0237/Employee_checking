package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.EvaluationDto;
import java.util.List;

public interface EvaluationService {

    EvaluationDto create(EvaluationDto evaluationDto);

    List<EvaluationDto> findAll();

    Optional<EvaluationDto> findById(UUID evaluationId);

    EvaluationDto update(UUID evaluationId, EvaluationDto evaluationDto);

    String deleteById(UUID evaluationId);

    String deleteAll();
}
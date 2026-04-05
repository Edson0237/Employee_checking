package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.QuestionDto;
import java.util.List;

public interface QuestionService {

    QuestionDto create(QuestionDto questionDto);

    List<QuestionDto> findAll();

    Optional<QuestionDto> findById(UUID questionId);

    QuestionDto update(UUID questionId, QuestionDto questionDto);

    String deleteById(UUID questionId);

    String deleteAll();
}


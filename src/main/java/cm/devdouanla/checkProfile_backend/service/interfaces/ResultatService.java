package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.ResultatDto;
import java.util.List;

public interface ResultatService {

    ResultatDto create(ResultatDto resultatDto);

    List<ResultatDto> findAll();

    Optional<ResultatDto> findById(UUID resultatId);

    ResultatDto update(UUID resultatId, ResultatDto resultatDto);

    String deleteById(UUID resultatId);

    String deleteAll();
}
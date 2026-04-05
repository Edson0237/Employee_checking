package cm.devdouanla.checkProfile_backend.service.interfaces;
import java.util.Optional;
import java.util.UUID;

import cm.devdouanla.checkProfile_backend.dto.TestDto;
import java.util.List;

public interface TestService {

    TestDto create(TestDto testDto);

    List<TestDto> findAll();

    Optional<TestDto> findById(UUID testId);

    TestDto update(UUID testId, TestDto testDto);

    String deleteById(UUID testId);

    String deleteAll();
}
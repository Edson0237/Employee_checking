package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.TestService;
import cm.devdouanla.checkProfile_backend.dto.TestDto;
import cm.devdouanla.checkProfile_backend.mappers.TestMapper;
import cm.devdouanla.checkProfile_backend.models.Test;
import cm.devdouanla.checkProfile_backend.repository.TestRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestServiceImp implements TestService {

    final private TestRepository testRepository;
    final private TestMapper testMapper;

    public TestServiceImp(TestRepository testRepository, TestMapper testMapper) {
        this.testRepository = testRepository;
        this.testMapper = testMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private TestDto save(TestDto testDto) {
        Test test = testMapper.toEntity(testDto);
        Test testSaved = testRepository.save(test);
        return testMapper.toDto(testSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public TestDto create(TestDto testDto) {
        return save(testDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<TestDto> findAll() {
        return testRepository.findAll().stream()
                .map(testMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<TestDto> findById(UUID testId) {
        return testRepository.findById(testId)
                .map(test -> TestDto.builder()
                        .id(test.getId())
                        .titre(test.getTitre())
                        .difficulte(test.getDifficulte())
                        .duree(test.getDuree())
                        .genereParIA(test.isGenereParIA())
                        .competence(test.getCompetence())
                       // .questions(test.getQuestions())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public TestDto update(UUID testId, TestDto testDto) {
        Optional<TestDto> testDtoOptional = findById(testId);

        if (testDtoOptional.isPresent()) {
            TestDto existingTestDto = testDtoOptional.get();

            if (testDto.getTitre() != null) {
                existingTestDto.setTitre(testDto.getTitre());
            }
            if (testDto.getDifficulte() != null) {
                existingTestDto.setDifficulte(testDto.getDifficulte());
            }
            if (testDto.getDuree() != 0) {
                existingTestDto.setDuree(testDto.getDuree());
            }
            if (testDto.isGenereParIA()) {
                existingTestDto.setGenereParIA(testDto.isGenereParIA());
            }
            if (testDto.getCompetence() != null) {
                existingTestDto.setCompetence(testDto.getCompetence());
            }
            if (testDto.getQuestions() != null) {
                existingTestDto.setQuestions(testDto.getQuestions());
            }

            return save(existingTestDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID testId) {
        testRepository.deleteById(testId);
        return "Le test a été supprimé avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        testRepository.deleteAll();
        return "La liste des tests a été supprimée avec succès";
    }
}

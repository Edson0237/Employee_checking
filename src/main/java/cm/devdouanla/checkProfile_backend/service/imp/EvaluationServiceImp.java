package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.EvaluationService;
import cm.devdouanla.checkProfile_backend.dto.EvaluationDto;
import cm.devdouanla.checkProfile_backend.mappers.EvaluationMapper;
import cm.devdouanla.checkProfile_backend.models.Evaluation;
import cm.devdouanla.checkProfile_backend.repository.EvaluationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EvaluationServiceImp implements EvaluationService {

    final private EvaluationRepository evaluationRepository;
    final private EvaluationMapper evaluationMapper;

    public EvaluationServiceImp(EvaluationRepository evaluationRepository, EvaluationMapper evaluationMapper) {
        this.evaluationRepository = evaluationRepository;
        this.evaluationMapper = evaluationMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private EvaluationDto save(EvaluationDto evaluationDto) {
        Evaluation evaluation = evaluationMapper.toEntity(evaluationDto);
        Evaluation evaluationSaved = evaluationRepository.save(evaluation);
        return evaluationMapper.toDto(evaluationSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public EvaluationDto create(EvaluationDto evaluationDto) {
        return save(evaluationDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<EvaluationDto> findAll() {
        return evaluationRepository.findAll().stream()
                .map(evaluationMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<EvaluationDto> findById(UUID evaluationId) {
        return evaluationRepository.findById(evaluationId)
                .map(evaluation -> EvaluationDto.builder()
                        .id(evaluation.getId())
                        .date(evaluation.getDate())
                        //.reponses(evaluation.getReponses())
                        .employe(evaluation.getEmploye())
                        .tests(evaluation.getTests())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public EvaluationDto update(UUID evaluationId, EvaluationDto evaluationDto) {
        Optional<EvaluationDto> evaluationDtoOptional = findById(evaluationId);

        if (evaluationDtoOptional.isPresent()) {
            EvaluationDto existingEvaluationDto = evaluationDtoOptional.get();

            if (evaluationDto.getDate() != null) {
                existingEvaluationDto.setDate(evaluationDto.getDate());
            }
            /*
            if (evaluationDto.getReponses() != null) {
                existingEvaluationDto.setReponses(evaluationDto.getReponses());
            }*/
         
            if (evaluationDto.getEmploye() != null) {
                existingEvaluationDto.setEmploye(evaluationDto.getEmploye());
            }
            if (evaluationDto.getTests() != null) {
                existingEvaluationDto.setTests(evaluationDto.getTests());
            }

            return save(existingEvaluationDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID evaluationId) {
        evaluationRepository.deleteById(evaluationId);
        return "L'évaluation a été supprimée avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        evaluationRepository.deleteAll();
        return "La liste des évaluations a été supprimée avec succès";
    }
}

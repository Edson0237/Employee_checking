package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.QuestionService;
import cm.devdouanla.checkProfile_backend.dto.QuestionDto;
import cm.devdouanla.checkProfile_backend.mappers.QuestionMapper;
import cm.devdouanla.checkProfile_backend.models.Question;
import cm.devdouanla.checkProfile_backend.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionServiceImp implements QuestionService {

    final private QuestionRepository questionRepository;
    final private QuestionMapper questionMapper;

    public QuestionServiceImp(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private QuestionDto save(QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        Question questionSaved = questionRepository.save(question);
        return questionMapper.toDto(questionSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public QuestionDto create(QuestionDto questionDto) {
        return save(questionDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<QuestionDto> findAll() {
        return questionRepository.findAll().stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<QuestionDto> findById(UUID questionId) {
        return questionRepository.findById(questionId)
                .map(question -> QuestionDto.builder()
                        .id(question.getId())
                        .enonce(question.getEnonce())
                        .reponses(question.getReponses())
                        .points(question.getPoints())
                       // .test(question.getTest())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public QuestionDto update(UUID questionId, QuestionDto questionDto) {
        Optional<QuestionDto> questionDtoOptional = findById(questionId);

        if (questionDtoOptional.isPresent()) {
            QuestionDto existingQuestionDto = questionDtoOptional.get();

            if (questionDto.getEnonce() != null) {
                existingQuestionDto.setEnonce(questionDto.getEnonce());
            }
            if (questionDto.getReponses() != null) {
                existingQuestionDto.setReponses(questionDto.getReponses());
            }
            if (questionDto.getPoints() != 0) {
                existingQuestionDto.setPoints(questionDto.getPoints());
            }
            if (questionDto.getPoints() != 0) {
                existingQuestionDto.setPoints(questionDto.getPoints());
            }
          
           

            return save(existingQuestionDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID questionId) {
        questionRepository.deleteById(questionId);
        return "La question a été supprimée avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        questionRepository.deleteAll();
        return "La liste des questions a été supprimée avec succès";
    }
}

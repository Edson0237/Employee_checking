package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.ReponseCandidatService;
import cm.devdouanla.checkProfile_backend.dto.ReponseCandidatDto;
import cm.devdouanla.checkProfile_backend.mappers.ReponseCandidatMapper;
import cm.devdouanla.checkProfile_backend.models.ReponseCandidat;
import cm.devdouanla.checkProfile_backend.repository.ReponseCandidatRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReponseCandidatServiceImp implements ReponseCandidatService {

    final private ReponseCandidatRepository reponseCandidatRepository;
    final private ReponseCandidatMapper reponseCandidatMapper;

    public ReponseCandidatServiceImp(ReponseCandidatRepository reponseCandidatRepository, ReponseCandidatMapper reponseCandidatMapper) {
        this.reponseCandidatRepository = reponseCandidatRepository;
        this.reponseCandidatMapper = reponseCandidatMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private ReponseCandidatDto save(ReponseCandidatDto reponseCandidatDto) {
        ReponseCandidat reponseCandidat = reponseCandidatMapper.toEntity(reponseCandidatDto);
        ReponseCandidat reponseCandidatSaved = reponseCandidatRepository.save(reponseCandidat);
        return reponseCandidatMapper.toDto(reponseCandidatSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public ReponseCandidatDto create(ReponseCandidatDto reponseCandidatDto) {
        return save(reponseCandidatDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<ReponseCandidatDto> findAll() {
        return reponseCandidatRepository.findAll().stream()
                .map(reponseCandidatMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<ReponseCandidatDto> findById(UUID reponseCandidatId) {
        return reponseCandidatRepository.findById(reponseCandidatId)
                .map(reponseCandidat -> ReponseCandidatDto.builder()
                    .id(reponseCandidat.getId())
                    .reponse(reponseCandidat.isReponse())
                    .question(reponseCandidat.getQuestion())
                    .employe(reponseCandidat.getEmploye())
                    .evaluation(reponseCandidat.getEvaluation())
                    .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public ReponseCandidatDto update(UUID reponseCandidatId, ReponseCandidatDto reponseCandidatDto) {
        Optional<ReponseCandidatDto> reponseCandidatDtoOptional = findById(reponseCandidatId);

        if (reponseCandidatDtoOptional.isPresent()) {
            ReponseCandidatDto existingReponseCandidatDto = reponseCandidatDtoOptional.get();

            existingReponseCandidatDto.setReponse(reponseCandidatDto.isReponse());
            if (reponseCandidatDto.getQuestion() != null) {
                existingReponseCandidatDto.setQuestion(reponseCandidatDto.getQuestion());
            }
            if (reponseCandidatDto.getEmploye() != null) {
                existingReponseCandidatDto.setEmploye(reponseCandidatDto.getEmploye());
            }
            if (reponseCandidatDto.getEvaluation() != null) {
                existingReponseCandidatDto.setEvaluation(reponseCandidatDto.getEvaluation());
            }
            return save(existingReponseCandidatDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID reponseCandidatId) {
        reponseCandidatRepository.deleteById(reponseCandidatId);
        return "La réponse candidat a été supprimée avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        reponseCandidatRepository.deleteAll();
        return "La liste des réponses candidat a été supprimée avec succès";
    }
}
package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.CompetenceService;
import cm.devdouanla.checkProfile_backend.dto.CompetenceDto;
import cm.devdouanla.checkProfile_backend.mappers.CompetenceMapper;
import cm.devdouanla.checkProfile_backend.models.Competence;
import cm.devdouanla.checkProfile_backend.repository.CompetenceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompetenceServiceImp implements CompetenceService {

    final private CompetenceRepository competenceRepository;
    final private CompetenceMapper competenceMapper;

    public CompetenceServiceImp(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private CompetenceDto save(CompetenceDto competenceDto) {
        Competence competence = competenceMapper.toEntity(competenceDto);
        Competence competenceSaved = competenceRepository.save(competence);
        return competenceMapper.toDto(competenceSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public CompetenceDto create(CompetenceDto competenceDto) {
        return save(competenceDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<CompetenceDto> findAll() {
        return competenceRepository.findAll().stream()
                .map(competenceMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<CompetenceDto> findById(UUID competenceId) {
        return competenceRepository.findById(competenceId)
                .map(competence -> CompetenceDto.builder()
                        .id(competence.getId())
                        .nom(competence.getNom())
                        .categorie(competence.getCategorie())
                        .description(competence.getDescription())
                        .niveauMax(competence.getNiveauMax())

                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public CompetenceDto update(UUID competenceId, CompetenceDto competenceDto) {
        Optional<CompetenceDto> competenceDtoOptional = findById(competenceId);

        if (competenceDtoOptional.isPresent()) {
            CompetenceDto existingCompetenceDto = competenceDtoOptional.get();

            if (competenceDto.getNom() != null) {
                existingCompetenceDto.setNom(competenceDto.getNom());
            }
            if (competenceDto.getCategorie() != null) {
                existingCompetenceDto.setCategorie(competenceDto.getCategorie());
            }
            if (competenceDto.getDescription() != null) {
                existingCompetenceDto.setDescription(competenceDto.getDescription());
            }
            if (competenceDto.getNiveauMax() != 0) {
                existingCompetenceDto.setNiveauMax(competenceDto.getNiveauMax());
            }
            if (competenceDto.getPostes() != null) {
                existingCompetenceDto.setPostes(competenceDto.getPostes());
            }
            if (competenceDto.getTests() != null) {
                existingCompetenceDto.setTests(competenceDto.getTests());
            }

            return save(existingCompetenceDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID competenceId) {
        competenceRepository.deleteById(competenceId);
        return "La compétence a été supprimée avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        competenceRepository.deleteAll();
        return "La liste des compétences a été supprimée avec succès";
    }
}

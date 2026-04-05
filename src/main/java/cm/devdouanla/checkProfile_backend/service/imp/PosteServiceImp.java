package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.PosteService;
import cm.devdouanla.checkProfile_backend.dto.PosteDto;
import cm.devdouanla.checkProfile_backend.mappers.PosteMapper;
import cm.devdouanla.checkProfile_backend.models.Poste;
import cm.devdouanla.checkProfile_backend.repository.PosteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PosteServiceImp implements PosteService {

    final private PosteRepository posteRepository;
    final private PosteMapper posteMapper;

    public PosteServiceImp(PosteRepository posteRepository, PosteMapper posteMapper) {
        this.posteRepository = posteRepository;
        this.posteMapper = posteMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private PosteDto save(PosteDto posteDto) {
        Poste poste = posteMapper.toEntity(posteDto);
        Poste posteSaved = posteRepository.save(poste);
        return posteMapper.toDto(posteSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public PosteDto create(PosteDto posteDto) {
        return save(posteDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<PosteDto> findAll() {
        return posteRepository.findAll().stream()
                .map(posteMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<PosteDto> findById(UUID posteId) {
        return posteRepository.findById(posteId)
                .map(poste -> PosteDto.builder()
                        .id(poste.getId())
                        .titre(poste.getTitre())
                        .niveau(poste.getNiveau())
                        .scoreMin(poste.getScoreMin())
                        .description(poste.getDescription())
                        .service(poste.getService())
                        .competences(poste.getCompetences())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public PosteDto update(UUID posteId, PosteDto posteDto) {
        Optional<PosteDto> posteDtoOptional = findById(posteId);

        if (posteDtoOptional.isPresent()) {
            PosteDto existingPosteDto = posteDtoOptional.get();

            if (posteDto.getTitre() != null) {
                existingPosteDto.setTitre(posteDto.getTitre());
            }
            if (posteDto.getNiveau() != null) {
                existingPosteDto.setNiveau(posteDto.getNiveau());
            }
            if (posteDto.getScoreMin() != 0) {
                existingPosteDto.setScoreMin(posteDto.getScoreMin());
            }
            if (posteDto.getDescription() != null) {
                existingPosteDto.setDescription(posteDto.getDescription());
            }
            if (posteDto.getService() != null) {
                existingPosteDto.setService(posteDto.getService());
            }
            if (posteDto.getCompetences() != null) {
                existingPosteDto.setCompetences(posteDto.getCompetences());
            }
            // if (posteDto.getProfil() != null) {
            //     existingPosteDto.setProfil(posteDto.getProfil());
            // }

            return save(existingPosteDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID posteId) {
        posteRepository.deleteById(posteId);
        return "Le poste a été supprimé avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        posteRepository.deleteAll();
        return "La liste des postes a été supprimée avec succès";
    }
}

package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.RapportConformiteService;
import cm.devdouanla.checkProfile_backend.dto.RapportConformiteDto;
import cm.devdouanla.checkProfile_backend.mappers.RapportConformiteMapper;
import cm.devdouanla.checkProfile_backend.models.RapportConformite;
import cm.devdouanla.checkProfile_backend.repository.RapportConformiteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class RapportConformiteServiceImp implements RapportConformiteService {

    final private RapportConformiteRepository rapportConformiteRepository;
    final private RapportConformiteMapper rapportConformiteMapper;

    public RapportConformiteServiceImp(RapportConformiteRepository rapportConformiteRepository, RapportConformiteMapper rapportConformiteMapper) {
        this.rapportConformiteRepository = rapportConformiteRepository;
        this.rapportConformiteMapper = rapportConformiteMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private RapportConformiteDto save(RapportConformiteDto rapportConformiteDto) {
        RapportConformite rapportConformite = rapportConformiteMapper.toEntity(rapportConformiteDto);
        RapportConformite rapportConformiteSaved = rapportConformiteRepository.save(rapportConformite);
        return rapportConformiteMapper.toDto(rapportConformiteSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public RapportConformiteDto create(RapportConformiteDto rapportConformiteDto) {
        return save(rapportConformiteDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<RapportConformiteDto> findAll() {
        return rapportConformiteRepository.findAll().stream()
                .map(rapportConformiteMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<RapportConformiteDto> findById(UUID rapportConformiteId) {
        return rapportConformiteRepository.findById(rapportConformiteId)
                .map(rapportConformite -> RapportConformiteDto.builder()
                        .id(rapportConformite.getId())
                        .dateGeneration(rapportConformite.getDateGeneration())
                        .recommandations(rapportConformite.getRecommandations())
                        .statut(rapportConformite.getStatut())
                        .employe(rapportConformite.getEmploye())
                        .resultats(rapportConformite.getResultats())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public RapportConformiteDto update(UUID rapportConformiteId, RapportConformiteDto rapportConformiteDto) {
        Optional<RapportConformiteDto> rapportConformiteDtoOptional = findById(rapportConformiteId);

        if (rapportConformiteDtoOptional.isPresent()) {
            RapportConformiteDto existingRapportConformiteDto = rapportConformiteDtoOptional.get();

            if (rapportConformiteDto.getDateGeneration() != null) {
                existingRapportConformiteDto.setDateGeneration(rapportConformiteDto.getDateGeneration());
            }
            if (rapportConformiteDto.getRecommandations() != null) {
                existingRapportConformiteDto.setRecommandations(rapportConformiteDto.getRecommandations());
            }
            if (rapportConformiteDto.getStatut() != null) {
                existingRapportConformiteDto.setStatut(rapportConformiteDto.getStatut());
            }
            if (rapportConformiteDto.getEmploye() != null) {
                existingRapportConformiteDto.setEmploye(rapportConformiteDto.getEmploye());
            }
            if (rapportConformiteDto.getResultats() != null) {
                existingRapportConformiteDto.setResultats(rapportConformiteDto.getResultats());
            }

            return save(existingRapportConformiteDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID rapportConformiteId) {
        rapportConformiteRepository.deleteById(rapportConformiteId);
        return "Le rapport de conformité a été supprimé avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        rapportConformiteRepository.deleteAll();
        return "La liste des rapports de conformité a été supprimée avec succès";
    }
}

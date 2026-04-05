package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.ResultatService;
import cm.devdouanla.checkProfile_backend.dto.ResultatDto;
import cm.devdouanla.checkProfile_backend.mappers.ResultatMapper;
import cm.devdouanla.checkProfile_backend.models.Resultat;
import cm.devdouanla.checkProfile_backend.repository.ResultatRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ResultatServiceImp implements ResultatService {

    final private ResultatRepository resultatRepository;
    final private ResultatMapper resultatMapper;

    public ResultatServiceImp(ResultatRepository resultatRepository, ResultatMapper resultatMapper) {
        this.resultatRepository = resultatRepository;
        this.resultatMapper = resultatMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private ResultatDto save(ResultatDto resultatDto) {
        Resultat resultat = resultatMapper.toEntity(resultatDto);
        Resultat resultatSaved = resultatRepository.save(resultat);
        return resultatMapper.toDto(resultatSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public ResultatDto create(ResultatDto resultatDto) {
        return save(resultatDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<ResultatDto> findAll() {
        return resultatRepository.findAll().stream()
                .map(resultatMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<ResultatDto> findById(UUID resultatId) {
        return resultatRepository.findById(resultatId)
                .map(resultat -> ResultatDto.builder()
                        .id(resultat.getId())
                        .scoreTotal(resultat.getScoreTotal())
                        .scoreMax(resultat.getScoreMax())
                        .pourcentage(resultat.getPourcentage())
                        .dateCalcul(resultat.getDateCalcul())
                        .employe(resultat.getEmploye())
                        .evaluations(resultat.getEvaluations())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public ResultatDto update(UUID resultatId, ResultatDto resultatDto) {
        Optional<ResultatDto> resultatDtoOptional = findById(resultatId);

        if (resultatDtoOptional.isPresent()) {
            ResultatDto existingResultatDto = resultatDtoOptional.get();

            if (resultatDto.getScoreTotal() != 0) {
                existingResultatDto.setScoreTotal(resultatDto.getScoreTotal());
            }
            if (resultatDto.getScoreMax() != 0) {
                existingResultatDto.setScoreMax(resultatDto.getScoreMax());
            }
            if (resultatDto.getPourcentage() != 0) {
                existingResultatDto.setPourcentage(resultatDto.getPourcentage());
            }
            if (resultatDto.getDateCalcul() != null) {
                existingResultatDto.setDateCalcul(resultatDto.getDateCalcul());
            }
            if (resultatDto.getEmploye() != null) {
                existingResultatDto.setEmploye(resultatDto.getEmploye());
            }
            if (resultatDto.getEvaluations() != null) {
                existingResultatDto.setEvaluations(resultatDto.getEvaluations());
            }

            return save(existingResultatDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID resultatId) {
        resultatRepository.deleteById(resultatId);
        return "Le résultat a été supprimé avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        resultatRepository.deleteAll();
        return "La liste des résultats a été supprimée avec succès";
    }
}

package cm.devdouanla.checkProfile_backend.service.imp;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cm.devdouanla.checkProfile_backend.service.interfaces.EmployeService;
import cm.devdouanla.checkProfile_backend.dto.EmployeDto;
import cm.devdouanla.checkProfile_backend.mappers.EmployeMapper;
import cm.devdouanla.checkProfile_backend.models.Employe;
import cm.devdouanla.checkProfile_backend.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeServiceImp implements EmployeService {

    final private EmployeRepository employeRepository;
    final private EmployeMapper employeMapper;

    public EmployeServiceImp(EmployeRepository employeRepository, EmployeMapper employeMapper) {
        this.employeRepository = employeRepository;
        this.employeMapper = employeMapper;
    }

    // ─── Méthode privée commune de sauvegarde ───────────────────────────────
    private EmployeDto save(EmployeDto employeDto) {
        Employe employe = employeMapper.toEntity(employeDto);
        Employe employeSaved = employeRepository.save(employe);
        return employeMapper.toDto(employeSaved);
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @Override
    public EmployeDto create(EmployeDto employeDto) {
        return save(employeDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @Override
    public List<EmployeDto> findAll() {
        return employeRepository.findAll().stream()
                .map(employeMapper::toDto)
                .collect(Collectors.toList());
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @Override
    public Optional<EmployeDto> findById(UUID employeId) {
        return employeRepository.findById(employeId)
                .map(employe -> EmployeDto.builder()
                        .id(employe.getId())
                        .nom(employe.getNom())
                        .prenom(employe.getPrenom())
                        .email(employe.getEmail())
                        .dateRecrutement(employe.getDateRecrutement())
                        .poste(employe.getPoste())
                        .build());
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @Override
    public EmployeDto update(UUID employeId, EmployeDto employeDto) {
        Optional<EmployeDto> employeDtoOptional = findById(employeId);

        if (employeDtoOptional.isPresent()) {
            EmployeDto existingEmployeDto = employeDtoOptional.get();

            if (employeDto.getNom() != null) {
                existingEmployeDto.setNom(employeDto.getNom());
            }
            if (employeDto.getPrenom() != null) {
                existingEmployeDto.setPrenom(employeDto.getPrenom());
            }
            if (employeDto.getEmail() != null) {
                existingEmployeDto.setEmail(employeDto.getEmail());
            }
            if (employeDto.getDateRecrutement() != null) {
                existingEmployeDto.setDateRecrutement(employeDto.getDateRecrutement());
            }
            if (employeDto.getPoste() != null) {
                existingEmployeDto.setPoste(employeDto.getPoste());
            }

            return save(existingEmployeDto);
        }

        return null;
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @Override
    public String deleteById(UUID employeId) {
        employeRepository.deleteById(employeId);
        return "L'employé a été supprimé avec succès";
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @Override
    public String deleteAll() {
        employeRepository.deleteAll();
        return "La liste des employés a été supprimée avec succès";
    }
}
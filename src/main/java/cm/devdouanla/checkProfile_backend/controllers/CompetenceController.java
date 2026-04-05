package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.CompetenceDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.CompetenceService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    final private CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping
    public CompetenceDto create(@RequestBody CompetenceDto competenceDto) {
        return competenceService.create(competenceDto);
    }

    @GetMapping
    public List<CompetenceDto> findAll() {
        return competenceService.findAll();
    }

    @GetMapping("/findById")
    public Optional<CompetenceDto> findById(@RequestParam UUID id) {
        return competenceService.findById(id);
    }

    @PutMapping("/update")
    public CompetenceDto update(@RequestParam UUID id, @RequestBody CompetenceDto competenceDto) {
        return competenceService.update(id, competenceDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return competenceService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return competenceService.deleteAll();
    }
}

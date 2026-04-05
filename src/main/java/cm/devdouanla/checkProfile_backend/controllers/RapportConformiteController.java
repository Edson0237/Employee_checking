package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.RapportConformiteDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.RapportConformiteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/rapports-conformite")
public class RapportConformiteController {

    final private RapportConformiteService rapportConformiteService;

    public RapportConformiteController(RapportConformiteService rapportConformiteService) {
        this.rapportConformiteService = rapportConformiteService;
    }

    @PostMapping
    public RapportConformiteDto create(@RequestBody RapportConformiteDto rapportConformiteDto) {
        return rapportConformiteService.create(rapportConformiteDto);
    }

    @GetMapping
    public List<RapportConformiteDto> findAll() {
        return rapportConformiteService.findAll();
    }

    @GetMapping("/findById")
    public Optional<RapportConformiteDto> findById(@RequestParam UUID id) {
        return rapportConformiteService.findById(id);
    }

    @PutMapping("/update")
    public RapportConformiteDto update(@RequestParam UUID id, @RequestBody RapportConformiteDto rapportConformiteDto) {
        return rapportConformiteService.update(id, rapportConformiteDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return rapportConformiteService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return rapportConformiteService.deleteAll();
    }
}

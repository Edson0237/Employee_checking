package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.ReponseCandidatDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.ReponseCandidatService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/reponses-candidat")
public class ReponseCandidatController {

    final private ReponseCandidatService reponseCandidatService;

    public ReponseCandidatController(ReponseCandidatService reponseCandidatService) {
        this.reponseCandidatService = reponseCandidatService;
    }

    @PostMapping
    public ReponseCandidatDto create(@RequestBody ReponseCandidatDto reponseCandidatDto) {
        return reponseCandidatService.create(reponseCandidatDto);
    }

    @GetMapping
    public List<ReponseCandidatDto> findAll() {
        return reponseCandidatService.findAll();
    }

    @GetMapping("/findById")
    public Optional<ReponseCandidatDto> findById(@RequestParam UUID id) {
        return reponseCandidatService.findById(id);
    }

    @PutMapping("/update")
    public ReponseCandidatDto update(@RequestParam UUID id, @RequestBody ReponseCandidatDto reponseCandidatDto) {
        return reponseCandidatService.update(id, reponseCandidatDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return reponseCandidatService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return reponseCandidatService.deleteAll();
    }
}

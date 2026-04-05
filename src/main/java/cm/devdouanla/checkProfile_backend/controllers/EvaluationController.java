package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.EvaluationDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.EvaluationService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    final private EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public EvaluationDto create(@RequestBody EvaluationDto evaluationDto) {
        return evaluationService.create(evaluationDto);
    }

    @GetMapping
    public List<EvaluationDto> findAll() {
        return evaluationService.findAll();
    }

    @GetMapping("/findById")
    public Optional<EvaluationDto> findById(@RequestParam UUID id) {
        return evaluationService.findById(id);
    }

    @PutMapping("/update")
    public EvaluationDto update(@RequestParam UUID id, @RequestBody EvaluationDto evaluationDto) {
        return evaluationService.update(id, evaluationDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return evaluationService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return evaluationService.deleteAll();
    }
}

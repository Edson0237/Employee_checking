package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.ResultatDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.ResultatService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/resultats")
public class ResultatController {

    final private ResultatService resultatService;

    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @PostMapping
    public ResultatDto create(@RequestBody ResultatDto resultatDto) {
        return resultatService.create(resultatDto);
    }

    @GetMapping
    public List<ResultatDto> findAll() {
        return resultatService.findAll();
    }

    @GetMapping("/findById")
    public Optional<ResultatDto> findById(@RequestParam UUID id) {
        return resultatService.findById(id);
    }

    @PutMapping("/update")
    public ResultatDto update(@RequestParam UUID id, @RequestBody ResultatDto resultatDto) {
        return resultatService.update(id, resultatDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return resultatService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return resultatService.deleteAll();
    }
}

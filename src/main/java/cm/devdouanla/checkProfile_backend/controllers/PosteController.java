package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.PosteDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.PosteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/postes")
public class PosteController {

    final private PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @PostMapping
    public PosteDto create(@RequestBody PosteDto posteDto) {
        return posteService.create(posteDto);
    }

    @GetMapping
    public List<PosteDto> findAll() {
        return posteService.findAll();
    }

    @GetMapping("/findById")
    public Optional<PosteDto> findById(@RequestParam UUID id) {
        return posteService.findById(id);
    }

    @PutMapping("/update")
    public PosteDto update(@RequestParam UUID id, @RequestBody PosteDto posteDto) {
        return posteService.update(id, posteDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return posteService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return posteService.deleteAll();
    }
}

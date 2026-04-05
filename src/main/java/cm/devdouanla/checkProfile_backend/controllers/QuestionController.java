package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.QuestionDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.QuestionService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/questions")
public class QuestionController {

    final private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public QuestionDto create(@RequestBody QuestionDto questionDto) {
        return questionService.create(questionDto);
    }

    @GetMapping
    public List<QuestionDto> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/findById")
    public Optional<QuestionDto> findById(@RequestParam UUID id) {
        return questionService.findById(id);
    }

    @PutMapping("/update")
    public QuestionDto update(@RequestParam UUID id, @RequestBody QuestionDto questionDto) {
        return questionService.update(id, questionDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return questionService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return questionService.deleteAll();
    }
}

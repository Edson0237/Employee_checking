package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.TestDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.TestService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tests")
public class TestController {

    final private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public TestDto create(@RequestBody TestDto testDto) {
        return testService.create(testDto);
    }

    @GetMapping
    public List<TestDto> findAll() {
        return testService.findAll();
    }

    @GetMapping("/findById")
    public Optional<TestDto> findById(@RequestParam UUID id) {
        return testService.findById(id);
    }

    @PutMapping("/update")
    public TestDto update(@RequestParam UUID id, @RequestBody TestDto testDto) {
        return testService.update(id, testDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return testService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return testService.deleteAll();
    }
}

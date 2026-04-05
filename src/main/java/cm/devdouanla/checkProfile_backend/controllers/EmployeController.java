package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.EmployeDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.EmployeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/employes")
public class EmployeController {

    final private EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────
    @PostMapping
    public EmployeDto create(@RequestBody EmployeDto employeDto) {
        return employeService.create(employeDto);
    }

    // ─── READ ALL ───────────────────────────────────────────────────────────
    @GetMapping
    public List<EmployeDto> findAll() {
        return employeService.findAll();
    }

    // ─── READ BY ID ─────────────────────────────────────────────────────────
    @GetMapping("/findById")
    public Optional<EmployeDto> findById(@RequestParam UUID id) {
        return employeService.findById(id);
    }

    // ─── UPDATE ─────────────────────────────────────────────────────────────
    @PutMapping("/update")
    public EmployeDto update(@RequestParam UUID id, @RequestBody EmployeDto employeDto) {
        return employeService.update(id, employeDto);
    }

    // ─── DELETE BY ID ───────────────────────────────────────────────────────
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return employeService.deleteById(id);
    }

    // ─── DELETE ALL ─────────────────────────────────────────────────────────
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return employeService.deleteAll();
    }
}

package cm.devdouanla.checkProfile_backend.controllers;

import org.springframework.web.bind.annotation.*;

import cm.devdouanla.checkProfile_backend.dto.ServiceDto;
import cm.devdouanla.checkProfile_backend.service.interfaces.ServiceService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/services")
public class ServiceController {

    final private ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ServiceDto create(@RequestBody ServiceDto serviceDto) {
        return serviceService.create(serviceDto);
    }

    @GetMapping
    public List<ServiceDto> findAll() {
        return serviceService.findAll();
    }

    @GetMapping("/findById")
    public Optional<ServiceDto> findById(@RequestParam UUID id) {
        return serviceService.findById(id);
    }

    @PutMapping("/update")
    public ServiceDto update(@RequestParam UUID id, @RequestBody ServiceDto serviceDto) {
        return serviceService.update(id, serviceDto);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam UUID id) {
        return serviceService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return serviceService.deleteAll();
    }
}

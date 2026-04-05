package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Service;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class EntrepriseDto {

    private UUID id;
    private String nom;
    private String secteur;
    private String adresse;
    private LocalDate dateCreation;
    private List<Service> services;

}

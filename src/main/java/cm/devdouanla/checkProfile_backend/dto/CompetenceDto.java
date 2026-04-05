package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.enums.Categorie;
import cm.devdouanla.checkProfile_backend.models.Poste;
import cm.devdouanla.checkProfile_backend.models.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDto {

    private UUID id;
    private String nom;
    private Categorie categorie;
    private String description;
    private int niveauMax;
    private Set<Poste> postes;
    private List<Test> tests;

}

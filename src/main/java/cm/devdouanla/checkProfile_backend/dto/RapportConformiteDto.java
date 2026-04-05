package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.enums.StatutConformite;
import cm.devdouanla.checkProfile_backend.models.Employe;
import cm.devdouanla.checkProfile_backend.models.Resultat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RapportConformiteDto {

    private UUID id;
    private LocalDateTime dateGeneration;
    private String recommandations;
    private StatutConformite statut;
    private Employe employe;
    private List<Resultat> resultats;

}

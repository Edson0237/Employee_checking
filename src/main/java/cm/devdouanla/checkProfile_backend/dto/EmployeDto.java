package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Evaluation;
import cm.devdouanla.checkProfile_backend.models.Poste;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {

    private UUID id;

    private String nom;

    private String prenom;

    private String email;

    private LocalDate dateRecrutement;

    private Poste poste;

    private List<Evaluation> evaluations;

}

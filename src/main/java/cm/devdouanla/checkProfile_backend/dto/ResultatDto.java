package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Employe;
import cm.devdouanla.checkProfile_backend.models.Evaluation;
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
public class ResultatDto {

    private UUID id;
    private float scoreTotal;
    private float scoreMax;
    private float pourcentage;
    private LocalDateTime dateCalcul;
    private Employe employe;
    private List<Evaluation> evaluations;

}

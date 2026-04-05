package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Competence;
import cm.devdouanla.checkProfile_backend.models.Employe;
import cm.devdouanla.checkProfile_backend.models.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {

    private UUID id;
    private LocalDateTime date;
    /*
    private Map<String, Integer> reponses;

     */
    private Employe employe;
    private Set<Test> tests;


}

package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Employe;
import cm.devdouanla.checkProfile_backend.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReponseCandidatDto {

    private UUID id;
    private boolean reponse;
    private Question question;
    private Employe employe;

}

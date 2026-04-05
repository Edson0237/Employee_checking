package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private UUID id;
    private String enonce;
    private String reponses; // Format: "reponse1;reponse2;reponse3;..."
    private int points;
    private String explication;
    private Test test;

}

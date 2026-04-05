package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.enums.Difficulte;
import cm.devdouanla.checkProfile_backend.models.Competence;
import cm.devdouanla.checkProfile_backend.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private UUID id;
    private String titre;
    private Difficulte difficulte;
    private int duree;
    private boolean genereParIA;
    private Competence competence;
    private List<Question> questions;

}

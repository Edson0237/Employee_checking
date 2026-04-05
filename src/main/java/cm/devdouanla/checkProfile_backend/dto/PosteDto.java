package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.enums.Niveau;
import cm.devdouanla.checkProfile_backend.models.Competence;
import cm.devdouanla.checkProfile_backend.models.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PosteDto {

    private UUID id;
    private String titre;
    private Niveau niveau;
    private int scoreMin;
    private String description;
    private Service service;
    private Set<Competence> competences;

}

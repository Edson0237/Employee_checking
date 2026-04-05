package cm.devdouanla.checkProfile_backend.dto;

import cm.devdouanla.checkProfile_backend.models.Poste;
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
public class ServiceDto {

    private UUID id;
    private String nom;
    private String description;
    private List<Poste> postes;

}

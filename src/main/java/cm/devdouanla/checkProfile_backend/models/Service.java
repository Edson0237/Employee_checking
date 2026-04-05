package cm.devdouanla.checkProfile_backend.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nom;

    private String description;


/**
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Poste> postes;

    public int getEffectif() {
        return postes != null ? postes.size() : 0;
    }
    **/
}

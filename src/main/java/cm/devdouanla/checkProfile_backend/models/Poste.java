package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.Niveau;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import   jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "poste")
public class Poste {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String titre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Niveau niveau;

    @Column(nullable = false)
    private int scoreMin;

    private String description;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToMany
    @JoinTable(
        name = "poste_competence",
        joinColumns = @JoinColumn(name = "poste_id"),
        inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private Set<Competence> competences = new HashSet<>();


    public boolean isConforme(Employe e) {
        // Logic to determine if the employee conforms to the requirements of the position
        return e.getScoreGlobal() >= scoreMin;
    }
}

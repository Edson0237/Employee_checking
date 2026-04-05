package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.StatutConformite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate dateRecrutement;

    @ManyToOne
    @JoinColumn(name = "poste_id", nullable = false)
    private Poste poste;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;

    public float getScoreGlobal() {
        // Logic to calculate the global score of the employee
        return 0.0f; // Placeholder return value
    }

    public StatutConformite getStatut() {
        // Logic to determine the conformity status of the employee
        return StatutConformite.NON_EVALUE; // Placeholder return value
    }
}

package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.Mention;
import cm.devdouanla.checkProfile_backend.enums

.StatutConformite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import   jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resultats")
public class Resultat {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private float scoreTotal;

    @Column(nullable = false)
    private float scoreMax;

    @Column(nullable = false)
    private float pourcentage;

    @Column(nullable = false)
    private LocalDateTime dateCalcul;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @ManyToMany
    @JoinTable(
        name = "resultat_evaluation",
        joinColumns = @JoinColumn(name = "resultat_id"),
        inverseJoinColumns = @JoinColumn(name = "evaluation_id")
    )
    private List<Evaluation> evaluations;

    public StatutConformite getStatut() {
        if (pourcentage >= 90) {
            return StatutConformite.CONFORME;
        } else if (pourcentage >= 60) {
            return StatutConformite.PARTIEL;
        } else {
            return StatutConformite.NON_CONFORME;
        }
    }

    public Mention getMention() {
        if (pourcentage >= 90) {
            return Mention.EXCELLENT;
        } else if (pourcentage >= 75) {
            return Mention.BIEN;
        } else if (pourcentage >= 60) {
            return Mention.PASSABLE;
        } else {
            return Mention.INSUFFISANT;
        }
    }

    public boolean isConforme() {
        return getStatut() == StatutConformite.CONFORME;
    }

    public float getEcart() {
        return scoreMax - scoreTotal;
    }
}
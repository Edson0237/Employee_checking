package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.Mention;
import cm.devdouanla.checkProfile_backend.enums.StatutConformite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @ManyToMany
    @JoinTable(
        name = "evaluation_test",
        joinColumns = @JoinColumn(name = "evaluation_id"),
        inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Set<Test> tests = new HashSet<>();

    // Les réponses du candidat pour cette évaluation
    @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL)
    private List<ReponseCandidat> reponses;

    public float calculerScore() {
        if (reponses == null || reponses.isEmpty()) return 0.0f;
        int totalPoints = 0;
        int pointsObtenus = 0;
        for (ReponseCandidat rc : reponses) {
            Question q = rc.getQuestion();
            if (q != null) {
                totalPoints += q.getPoints();
                if (rc.isReponse()) {
                    pointsObtenus += q.getPoints();
                }
            }
        }
        return totalPoints == 0 ? 0.0f : (float) pointsObtenus / totalPoints * 100;
    }

    public Mention getMention() {
        float score = calculerScore();
        if (score >= 90) return Mention.EXCELLENT;
        if (score >= 75) return Mention.BIEN;
        if (score >= 60) return Mention.PASSABLE;
        return Mention.INSUFFISANT;
    }

    public StatutConformite getStatut() {
        float score = calculerScore();
        if (score >= 90) return StatutConformite.CONFORME;
        if (score >= 60) return StatutConformite.PARTIEL;
        if (score == 0) return StatutConformite.NON_EVALUE;
        return StatutConformite.NON_CONFORME;
    }
}
package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.Mention;
import cm.devdouanla.checkProfile_backend.enums.StatutConformite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
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

    public float calculerScore() {
        // Logic to calculate score based on responses
        return 0.0f; // Placeholder return value
    }

    public Mention getMention() {
        // Logic to determine mention based on score
        return Mention.INSUFFISANT; // Placeholder return value
    }

    public StatutConformite getStatut() {
        // Logic to determine conformity status
        return StatutConformite.NON_EVALUE; // Placeholder return value
    }
}

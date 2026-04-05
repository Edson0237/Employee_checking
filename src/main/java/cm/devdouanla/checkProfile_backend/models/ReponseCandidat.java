package cm.devdouanla.checkProfile_backend.models;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reponse_candidat")
public class ReponseCandidat {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private boolean reponse;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "evaluation_id", nullable = false)
    private Evaluation evaluation;
}

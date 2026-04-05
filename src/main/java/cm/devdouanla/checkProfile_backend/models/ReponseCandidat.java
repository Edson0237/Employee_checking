package cm.devdouanla.checkProfile_backend.models;

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
@AllArgsConstructor

@NoArgsConstructor

@Entity
@Table(name = "reponse_candidat")
public class ReponseCandidat {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
 private boolean reponse; // true ou false
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;


}

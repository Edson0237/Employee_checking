package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.StatutConformite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rapport_conformite")
public class RapportConformite {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime dateGeneration;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String recommandations;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutConformite statut;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @ManyToMany
    @JoinTable(
        name = "rapport_resultat",
        joinColumns = @JoinColumn(name = "rapport_id"),
        inverseJoinColumns = @JoinColumn(name = "resultat_id")
    )
    private List<Resultat> resultats;

    public void generer() {
        // TODO: implémenter la logique de génération
    }

    public void exporter() {
        // TODO: implémenter la logique d'export
    }
}

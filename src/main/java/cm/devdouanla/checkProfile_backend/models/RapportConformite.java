package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.StatutConformite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import   jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data //genere  automatiquement les getters, setters, toString, equals et hashCode
@Builder //permet de construire des objets de manière fluide   ex: RapportConformite rapport = RapportConformite.builder().dateGeneration(LocalDateTime.now()).build();
@NoArgsConstructor //genere un constructeur sans arguments
@AllArgsConstructor //genere un constructeur avec tous les arguments
@Entity//indique que cette classe est une entité JPA qui sera mappée à une table de base de données
@Table(name = "rapport_conformite") //spécifie le nom de la table dans la base de données
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

    //@OneToMany(mappedBy = "rapportConformite", cascade = CascadeType.ALL)
    @Transient
     private List<Resultat> resultats;

    public void generer() {
        // Logic to generate the report
    }

    public void exporter() {
        // Logic to export the report
    }
}

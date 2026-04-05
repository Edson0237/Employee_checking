package cm.devdouanla.checkProfile_backend.models;

import cm.devdouanla.checkProfile_backend.enums.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import   jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data //genere  automatiquement les getters, setters, toString, equals et hashCode
@Builder //permet de construire des objets de manière fluide   ex: RapportConformite rapport = RapportConformite.builder().dateGeneration(LocalDateTime.now()).build();
@NoArgsConstructor //genere un constructeur sans arguments
@AllArgsConstructor //genere un constructeur avec tous les arguments
@Entity//indique que cette classe est une entité JPA qui sera mappée à une table de base de données
@Table(name = "competence") //spécifie le nom de la table dans la base de donnée

public class Competence {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorie categorie;

    private String description;

    @Column(nullable = false)
    private int niveauMax;


}

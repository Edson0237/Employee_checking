package cm.devdouanla.checkProfile_backend.repository;
import cm.devdouanla.checkProfile_backend.models.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PosteRepository extends JpaRepository<Poste, UUID> {
    // Additional query methods can be defined here if needed
}

package cm.devdouanla.checkProfile_backend.repository;
import cm.devdouanla.checkProfile_backend.models.ReponseCandidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReponseCandidatRepository extends JpaRepository<ReponseCandidat, UUID> {
    // Additional query methods can be defined here if needed
}
package ma.emsi.hospital.Repositories;

import ma.emsi.hospital.Entities.Patient;
import ma.emsi.hospital.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}

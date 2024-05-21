package ma.emsi.hospital.Repositories;

import ma.emsi.hospital.Entities.Consultation;
import ma.emsi.hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}

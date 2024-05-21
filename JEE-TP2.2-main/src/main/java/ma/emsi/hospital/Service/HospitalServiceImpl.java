package ma.emsi.hospital.Service;

import jakarta.transaction.Transactional;
import ma.emsi.hospital.Entities.Consultation;
import ma.emsi.hospital.Entities.Medecin;
import ma.emsi.hospital.Entities.Patient;
import ma.emsi.hospital.Entities.RendezVous;
import ma.emsi.hospital.Repositories.ConsultationRepository;
import ma.emsi.hospital.Repositories.MedecinRepository;
import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.Repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.UUID.*;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository PatientRepository;
    private MedecinRepository MedecinRepository;
    private RendezVousRepository RendezVousRepository;
    private ConsultationRepository ConsultationRepository;

    public HospitalServiceImpl(ma.emsi.hospital.Repositories.PatientRepository patientRepository) {
        PatientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient Patient) {
        return PatientRepository.save(Patient);
    }

    @Override
    public Medecin saveMedecin(Medecin Medecin) {
        return MedecinRepository.save(Medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous RendezVous) {
        RendezVous.setId(UUID.randomUUID().toString());
        return RendezVousRepository.save(RendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation Consultation) {
        return ConsultationRepository.save(Consultation);
    }
}

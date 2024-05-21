package ma.emsi.hospital.Service;

import ma.emsi.hospital.Entities.Consultation;
import ma.emsi.hospital.Entities.Medecin;
import ma.emsi.hospital.Entities.Patient;
import ma.emsi.hospital.Entities.RendezVous;

public interface IHospitalService {

     Patient savePatient(Patient Patient);
     Medecin saveMedecin(Medecin Medecin);
     RendezVous saveRDV(RendezVous RendezVous);
     Consultation saveConsultation(Consultation Consultation);
}

package ma.emsi.hospital;

import ch.qos.logback.core.net.SyslogOutputStream;
import ma.emsi.hospital.Entities.*;
import ma.emsi.hospital.Repositories.ConsultationRepository;
import ma.emsi.hospital.Repositories.MedecinRepository;
import ma.emsi.hospital.Repositories.PatientRepository;
import ma.emsi.hospital.Repositories.RendezVousRepository;
import ma.emsi.hospital.Service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.naming.Name;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService HospitalService,
							PatientRepository PatientRepository,
							RendezVousRepository RendezVousRepository,
							MedecinRepository MedecinRepository){
		return args -> {

			Stream.of("Mohamed","Hassan","Najat")
					.forEach(Name->{
						Patient Patient=new Patient();
						Patient.setName(Name);
						Patient.setDateNaissance(new Date());
						Patient.setMalade(false);
						HospitalService.savePatient(Patient);
					});

			Stream.of("Ayman","Hanane","Yasmine")
					.forEach(Name->{
						Medecin Medecin=new Medecin();
						Medecin.setName(Name);
						Medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						Medecin.setEmail(Name+"@gmail.com");
						HospitalService.saveMedecin(Medecin);
					});

			Patient Patient = PatientRepository.findById(1L).orElse(null);
			Patient Patient1= PatientRepository.findByName("Mohamed");

			Medecin Medecin=MedecinRepository.findByName("Yasmine");

			RendezVous RendezVous=new RendezVous();
			RendezVous.setDate(new Date());
			RendezVous.setStatus(StatusRDV.PENDING);
			RendezVous.setMedecin(Medecin);
			RendezVous.setPatient(Patient);
			RendezVous savedRDV = RendezVousRepository.save(RendezVous);
			System.out.println(savedRDV.getId());

			RendezVous RendezVous1=RendezVousRepository.findAll().get(0);

			Consultation Consultation=new Consultation();
			Consultation.setDateConsultation(new Date());
			Consultation.setRendezVous(RendezVous1);
			Consultation.setRapport("Rapport de la Consultation......");
			HospitalService.saveConsultation(Consultation);
		};
	}
}

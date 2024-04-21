package ma.fsm.tp02_partie02_hammam_salaheddine;

import ma.fsm.tp02_partie02_hammam_salaheddine.entities.*;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.MedecinRepository;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.PatientRepository;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.RendezVousRepository;
import ma.fsm.tp02_partie02_hammam_salaheddine.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp02Partie02HammamSalaheddineApplication  {

	public static void main(String[] args) {

		SpringApplication.run(Tp02Partie02HammamSalaheddineApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){
		return args -> {
			Stream.of("Mohamed","Hassan","Najat").forEach(name->{
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				hospitalService.savePatient(patient);
			});
			Stream.of("Aymane","Hassan","Ayoub").forEach(name->{
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				hospitalService.saveMedecin(medecin);
			});
		Patient patient = patientRepository.findById(1L).orElse(null);
		Patient patient1 = patientRepository.findByNom("Mohamed");

		Medecin medecin = medecinRepository.findByNom("Ayoub");

		RendezVous rendezVous = new RendezVous();
		rendezVous.setDate(new Date());
		rendezVous.setStatus(StatusRDV.PENDING);
		rendezVous.setMedecin(medecin);
		rendezVous.setPatient(patient);
		RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
		System.out.println(saveDRDV.getId());

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);

		Consultation consultation = new Consultation();
		consultation.setDateConsultaion(new Date());
		consultation.setRendezVous(rendezVous1);
		consultation.setRapport("Rapport de consultation ");
		hospitalService.saveConsultation(consultation);


		};
	}


}

package ma.fsm.tp02_partie02_hammam_salaheddine.service;

import jakarta.transaction.Transactional;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Consultation;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Medecin;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Patient;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.RendezVous;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.ConsultationRepository;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.MedecinRepository;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.PatientRepository;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}

package ma.fsm.tp02_partie02_hammam_salaheddine.service;

import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Consultation;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Medecin;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Patient;
import ma.fsm.tp02_partie02_hammam_salaheddine.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}

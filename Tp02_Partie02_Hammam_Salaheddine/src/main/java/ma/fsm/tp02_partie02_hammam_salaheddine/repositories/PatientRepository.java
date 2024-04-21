package ma.fsm.tp02_partie02_hammam_salaheddine.repositories;

import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}

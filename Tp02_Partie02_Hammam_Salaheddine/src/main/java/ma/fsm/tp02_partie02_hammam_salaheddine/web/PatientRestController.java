package ma.fsm.tp02_partie02_hammam_salaheddine.web;

import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Patient;
import ma.fsm.tp02_partie02_hammam_salaheddine.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> patientList() {
          return patientRepository.findAll();
    }

}

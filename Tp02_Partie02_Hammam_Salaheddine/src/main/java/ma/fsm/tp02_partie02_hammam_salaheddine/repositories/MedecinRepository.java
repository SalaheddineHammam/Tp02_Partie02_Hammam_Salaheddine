package ma.fsm.tp02_partie02_hammam_salaheddine.repositories;

import ma.fsm.tp02_partie02_hammam_salaheddine.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}

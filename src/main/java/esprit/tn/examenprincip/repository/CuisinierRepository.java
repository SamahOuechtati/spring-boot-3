package esprit.tn.examenprincip.repository;

import esprit.tn.examenprincip.entities.Cuisinier;
import esprit.tn.examenprincip.entities.Plat;
import org.hibernate.mapping.Selectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuisinierRepository extends JpaRepository<Cuisinier, Long> {



}

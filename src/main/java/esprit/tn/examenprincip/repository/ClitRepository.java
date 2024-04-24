package esprit.tn.examenprincip.repository;

import esprit.tn.examenprincip.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClitRepository extends JpaRepository<Client, Long> {

    Client  findByNomAndPrenom(String nom,String prenmo);
}

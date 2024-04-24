package esprit.tn.examenprincip.services;

import esprit.tn.examenprincip.entities.Categorie;
import esprit.tn.examenprincip.entities.Cuisinier;
import esprit.tn.examenprincip.repository.CuisinierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuisinierService implements ICuisinierService {

    @Autowired
    CuisinierRepository cuis;

    @Override
    public void ajouterCuisinier(Cuisinier cuisinier) {
        cuis.save(cuisinier);
        cuis.findAll();
    }

    @Scheduled(cron = "*/15 * * * * *")
    @Transactional
    @Override
    public void AfficherListeCuisinier() {
        List<Cuisinier> cuisiniers = cuis.findAll();

        // Filtrer les cuisiniers ayant préparé au moins deux plats de catégorie "Principal"
        List<Cuisinier> cuisiniersAvecPlatsPrincipaux = cuisiniers.stream()
                .filter(cuisinier -> cuisinier.getPlats().stream()
                        .filter(plat -> plat.getCategorie() == Categorie.PRINCIPAL)
                        .count() >= 2)
                .collect(Collectors.toList());

        // Afficher les cuisiniers
        System.out.println("Liste des cuisiniers ayant préparé au moins deux plats de catégorie Principal :");
        for (Cuisinier cuisinier : cuisiniersAvecPlatsPrincipaux) {
            System.out.println("Nom : " + cuisinier.getNom() + ", Prénom : " + cuisinier.getPrenom());
        }
    }


}

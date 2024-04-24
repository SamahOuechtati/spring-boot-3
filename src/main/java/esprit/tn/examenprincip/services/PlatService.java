package esprit.tn.examenprincip.services;

import esprit.tn.examenprincip.entities.Categorie;
import esprit.tn.examenprincip.entities.Client;
import esprit.tn.examenprincip.entities.Cuisinier;
import esprit.tn.examenprincip.entities.Plat;
import esprit.tn.examenprincip.repository.ClitRepository;
import esprit.tn.examenprincip.repository.CuisinierRepository;
import esprit.tn.examenprincip.repository.PaltRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PlatService implements IPlatService {

    @Autowired
    PaltRepository platrep;
    @Autowired
    ClitRepository clip;
    @Autowired
    CuisinierRepository cuisirep;

    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, long idClient, long idCuisinier) {
        Client client = clip.findById(idClient).orElseThrow();
        Cuisinier cuisinier = cuisirep.findById(idCuisinier).orElseThrow();

        if (client.getPlats().stream().filter(plat1 -> plat1.getCategorie() == Categorie.PRINCIPAL).count() < 2) {
            plat.setClients(client);
            plat.setCuisiniers(List.of(cuisinier));
            platrep.save(plat);
        } else if (client.getPlats().stream().filter(plat1 -> plat1.getCategorie() != Categorie.DESSERT).count() > 0) {
            plat.setClients(client);
            plat.setCuisiniers(List.of(cuisinier));
            platrep.save(plat);
        }  else if (client.getPlats().stream().filter(plat1 -> plat1.getCategorie() != Categorie.ENTREE).count() > 0) {
            plat.setClients(client);
            plat.setCuisiniers(List.of(cuisinier));
            platrep.save(plat);

        } else {
            throw new RuntimeException("Le client a déjà atteint la limite de commande de deux plats principaux.");
        }
    }

    @Override
    public List<Plat> AfficherListePlatsParClient(String nom, String prenom) {
        Client client = clip.findByNomAndPrenom(nom, prenom);

        // Vérifier si le client existe
        if (client == null) {
            throw new RuntimeException("Client non trouvé");
        }

        List<Plat> platsDuClient = client.getPlats();

        // Vérifier si le client a des plats associés
        if (platsDuClient.isEmpty()) {
            System.out.println("Le client n'a aucun plat associé.");
            return Collections.emptyList(); // Retourner une liste vide
        }

        return platsDuClient;
    }

    @Override
    public float MontantApayerParClient(long idClient) {
        Client client = clip.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        List<Plat> platsDuClient = client.getPlats();
        float montantTotal = 0;

        for (Plat plat : platsDuClient) {
            montantTotal += plat.getPrix();
        }

        return montantTotal;
    }
}




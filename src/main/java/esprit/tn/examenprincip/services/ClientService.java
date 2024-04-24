package esprit.tn.examenprincip.services;

import esprit.tn.examenprincip.entities.Client;
import esprit.tn.examenprincip.entities.Imc;
import esprit.tn.examenprincip.entities.Plat;
import esprit.tn.examenprincip.repository.ClitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {


    @Autowired
    ClitRepository cli;

    @Override
    public Client ajouterClient(Client client) {
        return cli.save(client);
    }

    @Override
    public List<Client> AfficherAllClient() {
        return cli.findAll();
    }

    @Override
    public void ModifierImc(long idClient) {
        Client client = cli.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        // Calculer le total des calories des plats consommés par le client
        List<Plat> platsDuClient = client.getPlats();
        long sum = 0;
        for (Plat plat : platsDuClient) {
            long calorie = plat.getCalorie();
            sum += calorie;
        }
        float totalCalories = sum;

        // Ajuster l'IMC en fonction du total des calories
        Imc imc;
        if (totalCalories < 2000) {
            imc = Imc.FAIBLE;
        } else if (totalCalories == 2000) {
            imc = Imc.IDEAL;
        } else {
            imc = Imc.FORT;
        }

        // Mettre à jour l'IMC du client dans la base de données
        client.setImc(imc);
        cli.save(client);
    }

}



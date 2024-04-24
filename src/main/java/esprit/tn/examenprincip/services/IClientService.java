package esprit.tn.examenprincip.services;

import esprit.tn.examenprincip.entities.Client;

import java.util.List;

public interface IClientService {

    public Client ajouterClient(Client client);
    public List <Client> AfficherAllClient();

    public void ModifierImc(long idClient);
}

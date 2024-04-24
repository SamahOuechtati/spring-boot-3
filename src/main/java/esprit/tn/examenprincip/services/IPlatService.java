package esprit.tn.examenprincip.services;

import esprit.tn.examenprincip.entities.Plat;

import java.util.List;

public interface IPlatService {


    public void ajouterPlatAffecterClientEtCuisinier (Plat plat, long idClient, long idCuisinier);

  public List<Plat> AfficherListePlatsParClient(String nom, String prenom);

    public float MontantApayerParClient(long idClient);


}

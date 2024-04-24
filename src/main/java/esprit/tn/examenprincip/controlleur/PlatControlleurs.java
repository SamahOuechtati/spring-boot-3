package esprit.tn.examenprincip.controlleur;

import esprit.tn.examenprincip.entities.Plat;
import esprit.tn.examenprincip.services.IPlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plats")

public class PlatControlleurs {

    @Autowired
    IPlatService ipl;
    @PostMapping("/ajouterPlatAffecterClientEtCuisinier/{idClient}/{idCuisinier}")
    public void ajouterPlatAffecterClientEtCuisinier (@RequestBody Plat plat, @PathVariable long idClient, @PathVariable long idCuisinier){
        ipl.ajouterPlatAffecterClientEtCuisinier(plat,idClient,idCuisinier);
    }

    @GetMapping("/AfficherListePlatsClient/{nom}/{prenom}")
    public List<Plat> AfficherListePlatsClient (@PathVariable String nom,@PathVariable String prenom){
        return ipl.AfficherListePlatsParClient(nom,prenom);
    }

    @GetMapping("/MontantApayerParClient/{idClient}")
    public float MontantApayerParClient(@PathVariable long idClient){
        return ipl.MontantApayerParClient(idClient);
    }

    }

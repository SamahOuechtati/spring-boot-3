package esprit.tn.examenprincip.controlleur;

import esprit.tn.examenprincip.entities.Cuisinier;
import esprit.tn.examenprincip.services.ICuisinierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuisiniers")
public class CuisinierControlleurs {
    @Autowired
    ICuisinierService icuisiniers;

    @PostMapping
    public void AjouterCuisiner(@RequestBody Cuisinier cuisinier){
        icuisiniers.ajouterCuisinier(cuisinier);
    }


    @GetMapping("/AfficherListeCuisinier")
    public void AfficherListeCuisinier() {
        icuisiniers.AfficherListeCuisinier();
    }


}

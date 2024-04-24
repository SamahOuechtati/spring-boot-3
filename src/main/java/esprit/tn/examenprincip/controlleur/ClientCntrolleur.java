package esprit.tn.examenprincip.controlleur;


import esprit.tn.examenprincip.entities.Client;
import esprit.tn.examenprincip.services.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientCntrolleur {

     @Autowired
    IClientService icli;

     @PostMapping
    public Client ajouterClient(@RequestBody Client client){
        return icli.ajouterClient(client);
    }

    @GetMapping
    public List <Client> AfficherClient(){
        return icli.AfficherAllClient();
    }

    @PostMapping("/ModifierImc/{idClient}")
    public void ModifierImc(@PathVariable long idClient){
          icli.ModifierImc(idClient);
    }


}

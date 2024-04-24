package esprit.tn.examenprincip.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cuisiniers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuisinier {

    @ManyToMany(mappedBy = "cuisiniers")
    private List<Plat>plats;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idCuisinier")
    long idCuisinier;
    String nom;

    String prenom;

}

package esprit.tn.examenprincip.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "plats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plat {


    @ManyToOne
    private Client clients;
    @ManyToMany
    private List<Cuisinier> cuisiniers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idPlat")
    long idPlat;
    String label;
    float prix;
    long calorie;

    @Enumerated(EnumType.STRING)
    Categorie categorie;
}

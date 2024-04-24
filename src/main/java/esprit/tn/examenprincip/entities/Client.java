package esprit.tn.examenprincip.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Client {


        @OneToMany(mappedBy = "clients")
        private List<Plat> plats;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name = "idClient")
        long idClient;
        String nom;

        String prenom;
        @Enumerated (EnumType.STRING)
        Imc imc;










}

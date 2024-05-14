package org.parking.gestio_parking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.num.TypePersonne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCompte;
    private String email;
    private int MotDePasse;
    @OneToOne
    private Client person;
    @OneToOne
    private Admin admin;
    private TypePersonne type;

}

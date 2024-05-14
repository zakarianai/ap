package org.parking.gestio_parking.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Reservation ;
    private Date Date_entree;
    private Date Date_retour;
    @ManyToOne
    private Client client;
    @OneToOne
    private Place place ;
    @OneToOne
    private Vehicule vehicule;


}

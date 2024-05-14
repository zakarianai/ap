package org.parking.gestio_parking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private int tva;
    private int prix;
    @OneToOne
    private Reservation reservation;
}

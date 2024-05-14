package org.parking.gestio_parking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.num.Etatplace;

import java.util.Date;
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Place;
    private Etatplace etatplace;
    @ManyToOne
    @JoinColumn(name = "Id_parking")
    private Parking parking ;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Place() {
    }

    public Place(int num_place, Etatplace etatplace) {


        this.etatplace = etatplace;
    }





    public int getId_Place() {
        return Id_Place;
    }

    public void setId_Place(int id_Place) {
        Id_Place = id_Place;
    }



    public Etatplace getEtatplace() {
        return etatplace;
    }

    public void setEtatplace(Etatplace etatplace) {
        this.etatplace = etatplace;
    }


}

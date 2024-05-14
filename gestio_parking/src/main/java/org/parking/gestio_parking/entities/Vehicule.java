package org.parking.gestio_parking.entities;

import jakarta.persistence.*;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id_vehicule ;
    String matricule;




    public Vehicule() {
    }

    public int getId_vehicule() {
        return Id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        Id_vehicule = id_vehicule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Vehicule( String matricule) {
        this.matricule = matricule;
    }
}

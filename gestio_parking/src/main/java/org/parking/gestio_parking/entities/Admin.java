package org.parking.gestio_parking.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@DiscriminatorValue("admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
    //les variables en minuscule
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String address;
    private String username;
    private String email;
    private String password;
    @OneToOne
    private  Compte compte;
    @OneToOne
    @JoinColumn(name = "Id_parking")
    private Parking parking;
    /*public Admin (){

    }
    public Admin(String nom, String prenom, int telephone, String adresse_client, String nom_utilisateur, String email, String mot_de_passe, Compte compte) {
        super(nom, prenom, telephone, adresse_client, nom_utilisateur, email, mot_de_passe);
        this.compte = compte;
    }

    public Admin(String nom, String prenom, int telephone, String adresse_client, String nom_utilisateur, String email, String mot_de_passe) {
        super(nom, prenom, telephone, adresse_client, nom_utilisateur, email, mot_de_passe);
    }*/
}

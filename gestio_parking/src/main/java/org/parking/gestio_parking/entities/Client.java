package org.parking.gestio_parking.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@DiscriminatorValue("Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String name;
    private String Prenom;
    private int Telephone;
    private String Adresse_client;
    private String Nom_utilisateur;
    private String Email;
    private String Mot_de_passe;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservationsList;
    @OneToOne
    private  Compte compte;

    /*public Client(String nom, String prenom, int telephone, String adresse_client, String nom_utilisateur, String email, String mot_de_passe, List<Reservation> reservationsList, Compte compte) {
        super(nom, prenom, telephone, adresse_client, nom_utilisateur, email, mot_de_passe);
        //this.reservationsList = reservationsList;
        //this.compte = compte;
    }

    public Client(String nom, String prenom, int telephone, String adresse_client, String nom_utilisateur, String email, String mot_de_passe) {
        super(nom, prenom, telephone, adresse_client, nom_utilisateur, email, mot_de_passe);
    }

    public Client() {

    }*/
}

package org.parking.gestio_parking.Dto;

import lombok.*;

@Data
public class ClientDto {
    private int idClient;
    private String Nom;
    private String Prenom;
    private int Telephone;
    private String Adresse_client;
    private String Nom_utilisateur;
    private String Email;

    /*public int getId_personne() {
        return Id_personne;
    }

    public void setId_personne(int id_personne) {
        Id_personne = id_personne;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int telephone) {
        Telephone = telephone;
    }

    public String getAdresse_client() {
        return Adresse_client;
    }

    public void setAdresse_client(String adresse_client) {
        Adresse_client = adresse_client;
    }

    public String getNom_utilisateur() {
        return Nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        Nom_utilisateur = nom_utilisateur;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }*/
}

package org.parking.gestio_parking.Dto;

import lombok.Data;
import org.parking.gestio_parking.num.TypePersonne;

@Data
public class CompteDto {

    private int IdCompte;
    private String email;
    private int MotDePasse;
    private TypePersonne type;


}

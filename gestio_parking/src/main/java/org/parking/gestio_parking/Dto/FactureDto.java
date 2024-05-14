package org.parking.gestio_parking.Dto;

import jakarta.persistence.OneToOne;
import lombok.Data;
import org.parking.gestio_parking.entities.Reservation;

import java.util.Date;
@Data
public class FactureDto {
    private int idfacture;
    private Date date;
    private int tva;
    private int prix;
    private int reservationID;
}

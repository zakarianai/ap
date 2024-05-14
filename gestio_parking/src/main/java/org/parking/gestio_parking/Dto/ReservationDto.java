package org.parking.gestio_parking.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class ReservationDto {
    private int Id_Reservation;
    private Date Date_entree;
    private Date Date_retour;
    private int clientId;
    private int vehiculeId;
    private int placeId ;


}

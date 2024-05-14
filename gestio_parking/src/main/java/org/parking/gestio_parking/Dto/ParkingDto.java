package org.parking.gestio_parking.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
public class ParkingDto {
    private int Id_parking;
    private String Adresse;
    private String Regions;
    private int Telephone;
    private int Prix;
    private int nomber_place;
    private int adminId;
    private List<PlaceDto> places;

}

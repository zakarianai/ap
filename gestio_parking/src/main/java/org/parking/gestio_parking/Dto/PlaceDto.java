package org.parking.gestio_parking.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.parking.gestio_parking.entities.Parking;
import org.parking.gestio_parking.entities.Place;
import org.parking.gestio_parking.num.Etatplace;

import java.util.List;
@Data
public class PlaceDto {
    private int Id_Place;
    private Etatplace etatplace;
    private int parkingId;
}

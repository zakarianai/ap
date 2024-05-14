package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.ParkingDto;
import org.parking.gestio_parking.Exceptions.ExceptionParkingNotFound;

import java.util.List;

public interface ParkingService {
    ParkingDto SaveParking(ParkingDto parkingDto);
    ParkingDto UpdateParking(int id , ParkingDto parkingDto) throws ExceptionParkingNotFound;
    void DeleteParking(int id );
    List<ParkingDto> listeparking();
    ParkingDto park(int id ) throws ExceptionParkingNotFound;

}

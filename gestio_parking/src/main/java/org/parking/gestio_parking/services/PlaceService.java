package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.PlaceDto;
import org.parking.gestio_parking.Exceptions.ExceptionPlaceNotFoud;

import java.util.List;

public interface PlaceService {
    PlaceDto SavePlace(PlaceDto placeDto);
    List<PlaceDto> listePlace();
    PlaceDto placeById(int id) throws ExceptionPlaceNotFoud;
    void Delete(int id);
    PlaceDto Updateplace(int id ,PlaceDto placeDto) throws ExceptionPlaceNotFoud;

}

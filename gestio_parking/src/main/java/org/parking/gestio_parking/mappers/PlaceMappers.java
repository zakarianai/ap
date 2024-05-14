package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.ParkingDto;
import org.parking.gestio_parking.Dto.PlaceDto;
import org.parking.gestio_parking.Exceptions.ExceptionParkingNotFound;
import org.parking.gestio_parking.entities.Parking;
import org.parking.gestio_parking.entities.Place;
import org.parking.gestio_parking.repositories.ParkingRepository;
import org.parking.gestio_parking.services.ParkingService;
import org.parking.gestio_parking.services.ParkingServiceImplt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PlaceMappers {

    public Place fromPlaceDto(PlaceDto placeDto)  {
        Place place = new Place();
        BeanUtils.copyProperties(placeDto,place);
        if (placeDto.getParkingId() != 0){
            Parking parking = new Parking();
            parking.setId_parking(placeDto.getParkingId());
            place.setParking(parking);
        }
        return place;
    }
    public PlaceDto fromPlace(Place place){
        PlaceDto placeDto = new PlaceDto();
        BeanUtils.copyProperties(place,placeDto);
        if (place.getParking()!=null){
            placeDto.setParkingId(place.getParking().getId_parking());
        }
        return placeDto;
    }
}

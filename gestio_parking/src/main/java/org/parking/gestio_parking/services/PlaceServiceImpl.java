package org.parking.gestio_parking.services;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.PlaceDto;
import org.parking.gestio_parking.Exceptions.ExceptionPlaceNotFoud;
import org.parking.gestio_parking.entities.Place;
import org.parking.gestio_parking.mappers.PlaceMappers;
import org.parking.gestio_parking.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService{
    @Autowired
    private PlaceMappers placeMappers;
    @Autowired
    private PlaceRepository placeRepository;
    @Override
    public PlaceDto SavePlace(PlaceDto placeDto) {
        Place place = placeMappers.fromPlaceDto(placeDto);
        Place place1=placeRepository.save(place);
        return placeMappers.fromPlace(place1);
    }

    @Override
    public List<PlaceDto> listePlace() {
        List<Place> places = placeRepository.findAll();
        List<PlaceDto> placeDtos=places.stream().map(place -> placeMappers.fromPlace(place)).collect(Collectors.toList());
        return placeDtos;
    }

    @Override
    public PlaceDto placeById(int id) throws ExceptionPlaceNotFoud {
        Place placeByid = placeRepository.findById(id).orElseThrow(()->new ExceptionPlaceNotFoud("Place not Found"));
        return placeMappers.fromPlace(placeByid);
    }

    @Override
    public void Delete(int id) {
        placeRepository.deleteById(id);
    }

    @Override
    public PlaceDto Updateplace(int id, PlaceDto placeDto) throws ExceptionPlaceNotFoud {
        Place place= placeRepository.findById(id).orElseThrow(()->new ExceptionPlaceNotFoud("Place not found"));
        Place newplace = placeMappers.fromPlaceDto(placeDto);
        place.setEtatplace(newplace.getEtatplace());
        return placeMappers.fromPlace(newplace);
    }
}

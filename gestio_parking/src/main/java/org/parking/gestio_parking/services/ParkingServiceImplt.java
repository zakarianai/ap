package org.parking.gestio_parking.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.Dto.ParkingDto;
import org.parking.gestio_parking.Exceptions.ExceptionParkingNotFound;
import org.parking.gestio_parking.entities.Parking;
import org.parking.gestio_parking.mappers.ParkingMappers;
import org.parking.gestio_parking.repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor

public class ParkingServiceImplt implements ParkingService{
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingMappers parkingMappers;


    @Override
    public ParkingDto SaveParking(ParkingDto parkingDto) {
        Parking parking=parkingMappers.fromParkingDto(parkingDto);
        parkingRepository.save(parking);
        ParkingDto parkingDto1=parkingMappers.fromParking(parking);
        return parkingDto1;
    }

    @Override
    public ParkingDto UpdateParking(int id, ParkingDto parkingDto) throws ExceptionParkingNotFound {
        Parking parking = parkingRepository.findById(id).orElseThrow(()->new ExceptionParkingNotFound("Parking not found"));
        Parking parkingnew=parkingMappers.fromParkingDto(parkingDto);
        parking.setAdresse(parkingnew.getAdresse());
        parking.setTelephone(parkingnew.getTelephone());
        parking.setPrix(parkingnew.getPrix());
        parking.setRegions(parkingnew.getRegions());
        parking.setNomber_place(parkingnew.getNomber_place());
        parking.setPlaces(parkingnew.getPlaces());
        return parkingMappers.fromParking(parking);
    }

    @Override
    public void DeleteParking(int id) {
        parkingRepository.deleteById(id);

    }

    @Override
    public List<ParkingDto> listeparking() {
        List<Parking> list =parkingRepository.findAll();
        List<ParkingDto> list1 = list.stream().map(park -> parkingMappers.fromParking(park)).collect(Collectors.toList());

        return list1;
    }

    @Override
    public ParkingDto park(int id) throws ExceptionParkingNotFound {
        Parking parking = parkingRepository.findById(id).orElseThrow(()->new ExceptionParkingNotFound("Parking not found"));
        return parkingMappers.fromParking(parking);
    }
}

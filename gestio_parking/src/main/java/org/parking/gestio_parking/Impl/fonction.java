package org.parking.gestio_parking.Impl;

import org.parking.gestio_parking.Dto.ParkingDto;
import org.parking.gestio_parking.Dto.PlaceDto;
import org.parking.gestio_parking.services.ParkingService;
import org.parking.gestio_parking.services.PlaceService;

import java.util.ArrayList;
import java.util.List;

import static org.parking.gestio_parking.num.Etatplace.DESPO;

public class fonction {
    public void creationPark (){
        ParkingService parkingService = null;
        PlaceService placeService = null;
        System.out.println("creation park");
        ParkingDto parkingDto = new ParkingDto();
        parkingDto.setAdresse("aaaaa");
        parkingDto.setPrix(00);
        parkingDto.setRegions("marrakech");
        parkingDto.setTelephone(666666666);
        parkingDto.setNomber_place(11);
        PlaceDto placeDto=new PlaceDto();
        List<PlaceDto> pl= new ArrayList<>();
        parkingDto.setPlaces(pl);
        parkingDto = parkingService.SaveParking(parkingDto);
        for(int i=0;i<parkingDto.getNomber_place(); i++){
            System.out.println("yyyyyy");
            placeDto.setEtatplace(DESPO);
            placeDto.setParkingId(parkingDto.getId_parking());
            placeService.SavePlace(placeDto);
            pl.add(placeDto);
        }
    }
}

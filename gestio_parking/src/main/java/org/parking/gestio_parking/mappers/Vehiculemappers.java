package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.VehiculeDto;
import org.parking.gestio_parking.entities.Vehicule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class Vehiculemappers {

    public Vehicule fromVehiculeDto(VehiculeDto vehiculeDto){
        Vehicule vehicule=new Vehicule();
        BeanUtils.copyProperties(vehiculeDto,vehicule);
        return vehicule;
    }
    public VehiculeDto fromVehicule (Vehicule vehicule){
        VehiculeDto vehiculeDto=new VehiculeDto();
        BeanUtils.copyProperties(vehicule,vehiculeDto);
        return vehiculeDto;
    }
}

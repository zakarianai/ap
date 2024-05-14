package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.ParkingDto;
import org.parking.gestio_parking.entities.Admin;
import org.parking.gestio_parking.entities.Parking;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ParkingMappers {
    public Parking fromParkingDto(ParkingDto parkingDto){
        Parking parking=new Parking();
        BeanUtils.copyProperties(parkingDto,parking);
        if(parkingDto.getAdminId() != 0){
            Admin admin = new Admin();
            admin.setAdminId(parkingDto.getAdminId());
            parking.setAdmin(admin);
        }
        return parking;
    }
    public ParkingDto fromParking (Parking parking){
        ParkingDto parkingDto = new ParkingDto();
        BeanUtils.copyProperties(parking,parkingDto);
        if (parking.getAdmin()!=null){
            parkingDto.setAdminId(parking.getAdmin().getAdminId());
        }
        return parkingDto;
    }
}

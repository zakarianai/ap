package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.VehiculeDto;
import org.parking.gestio_parking.Exceptions.ExceptionVehiculeNotFound;

import java.util.List;

public interface VehiculeService {
    VehiculeDto saveVehicule(VehiculeDto vehiculeDto);
    List<VehiculeDto> listeVehicule();
    VehiculeDto vehiculeById(int id) throws ExceptionVehiculeNotFound;
    void deleteVehicule(int id);
    VehiculeDto updateVehicule(int id , VehiculeDto vehiculeDto) throws ExceptionVehiculeNotFound;
}

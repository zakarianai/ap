package org.parking.gestio_parking.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.Dto.VehiculeDto;
import org.parking.gestio_parking.Exceptions.ExceptionVehiculeNotFound;
import org.parking.gestio_parking.entities.Vehicule;
import org.parking.gestio_parking.mappers.Vehiculemappers;
import org.parking.gestio_parking.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeServiceImpl implements VehiculeService{
    @Autowired
    private Vehiculemappers vehiculemappers;
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Override
    public VehiculeDto saveVehicule(VehiculeDto vehiculeDto) {
        Vehicule vehicule =vehiculemappers.fromVehiculeDto(vehiculeDto);
        vehiculeRepository.save(vehicule);
        return vehiculemappers.fromVehicule(vehicule);
    }

    @Override
    public List<VehiculeDto> listeVehicule() {
        List<Vehicule> listeVehicule = vehiculeRepository.findAll();
        List<VehiculeDto> list=listeVehicule.stream().map(vehicule -> vehiculemappers.fromVehicule(vehicule)).collect(Collectors.toList());
        return list;
    }

    @Override
    public VehiculeDto vehiculeById(int id) throws ExceptionVehiculeNotFound {
        Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow(()->new ExceptionVehiculeNotFound("Vehicule not found"));

        return vehiculemappers.fromVehicule(vehicule);
    }

    @Override
    public void deleteVehicule(int id) {

        vehiculeRepository.deleteById(id);

    }

    @Override
    public VehiculeDto updateVehicule(int id, VehiculeDto vehiculeDto) throws ExceptionVehiculeNotFound {
        Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow(()->new ExceptionVehiculeNotFound("Vehicule not found"));
        Vehicule newvehicule=vehiculemappers.fromVehiculeDto(vehiculeDto);
        vehicule.setMatricule(newvehicule.getMatricule());
        return null;
    }
}

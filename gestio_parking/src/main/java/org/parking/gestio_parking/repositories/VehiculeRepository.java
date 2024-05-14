package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
}

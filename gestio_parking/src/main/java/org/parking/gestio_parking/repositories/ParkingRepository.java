package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking,Integer> {
}

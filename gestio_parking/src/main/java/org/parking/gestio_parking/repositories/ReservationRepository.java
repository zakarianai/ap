package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}

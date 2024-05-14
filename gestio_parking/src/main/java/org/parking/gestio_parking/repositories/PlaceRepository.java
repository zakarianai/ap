package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Integer> {
}

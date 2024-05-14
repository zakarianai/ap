package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Integer> {
}

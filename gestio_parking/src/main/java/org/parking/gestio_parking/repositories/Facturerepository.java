package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Facturerepository extends JpaRepository<Facture,Integer> {
}

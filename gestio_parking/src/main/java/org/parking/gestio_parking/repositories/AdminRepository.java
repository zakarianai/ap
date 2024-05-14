package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}

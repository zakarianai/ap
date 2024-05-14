package org.parking.gestio_parking.repositories;

import org.parking.gestio_parking.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientrepository extends JpaRepository<Client,Integer> {
    // @Query("select c from Person where c.Nom like :kw")
    // List<Client> listeClients ( @Param("kw") String key);
}

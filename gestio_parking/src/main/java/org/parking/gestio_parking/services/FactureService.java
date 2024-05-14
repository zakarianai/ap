package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.FactureDto;
import org.parking.gestio_parking.Exceptions.ExceptionFactureNotFound;

import java.util.List;

public interface FactureService {
    FactureDto saveFacture (FactureDto factureDto);
    FactureDto updateFacture(int id ,FactureDto factureDto) throws ExceptionFactureNotFound;
    List<FactureDto> listeFacture();
    FactureDto factureById(int id) throws ExceptionFactureNotFound;
    void deleteFacture(int id );
}

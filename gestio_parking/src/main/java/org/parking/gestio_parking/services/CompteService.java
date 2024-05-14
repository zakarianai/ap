package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.CompteDto;
import org.parking.gestio_parking.Exceptions.ExceptionCompteNotFound;

import java.util.List;

public interface CompteService {
    CompteDto saveCompte(CompteDto compteDto);
    CompteDto updateCompte(int id,CompteDto compteDto) throws ExceptionCompteNotFound;
    List<CompteDto> listCompte();
    CompteDto compteById(int id) throws ExceptionCompteNotFound;
    void deleteCompte(int id);
}

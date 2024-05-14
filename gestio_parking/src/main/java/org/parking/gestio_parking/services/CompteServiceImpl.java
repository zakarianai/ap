package org.parking.gestio_parking.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.Dto.CompteDto;
import org.parking.gestio_parking.Exceptions.ExceptionCompteNotFound;
import org.parking.gestio_parking.entities.Compte;
import org.parking.gestio_parking.mappers.CompteMappers;
import org.parking.gestio_parking.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class CompteServiceImpl implements CompteService{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteMappers compteMappers;


    @Override
    public CompteDto saveCompte(CompteDto compteDto) {
        Compte compte = compteMappers.fromCompteDto(compteDto);
        compteRepository.save(compte);
        return compteMappers.fromCompte(compte);
    }

    @Override
    public CompteDto updateCompte(int id, CompteDto compteDto) throws ExceptionCompteNotFound {
        Compte compte = compteRepository.findById(id).orElseThrow(()->new ExceptionCompteNotFound("Compte not found"));
        Compte newcompte=compteMappers.fromCompteDto(compteDto);
        compte.setEmail(newcompte.getEmail());
        compte.setMotDePasse(newcompte.getMotDePasse());
        compte.setType(newcompte.getType());
        return compteMappers.fromCompte(compte);
    }

    @Override
    public List<CompteDto> listCompte() {
        List<Compte>compteList=compteRepository.findAll();
        return compteList.stream().map(cm->compteMappers.fromCompte(cm)).collect(Collectors.toList());
    }

    @Override
    public CompteDto compteById(int id) throws ExceptionCompteNotFound {
        Compte compte = compteRepository.findById(id).orElseThrow(()->new ExceptionCompteNotFound("Compte not found"));
        return compteMappers.fromCompte(compte);
    }

    @Override
    public void deleteCompte(int id) {
        compteRepository.deleteById(id);

    }
}

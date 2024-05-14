package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.CompteDto;
import org.parking.gestio_parking.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CompteMappers {
    public Compte fromCompteDto(CompteDto compteDto){
        Compte compte=new Compte();
        BeanUtils.copyProperties(compteDto,compte);
        return compte;
    }
    public CompteDto fromCompte(Compte compte){
        CompteDto compteDto=new CompteDto();
        BeanUtils.copyProperties(compte,compteDto);
        return compteDto;
    }
}

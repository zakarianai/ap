package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.FactureDto;
import org.parking.gestio_parking.entities.Facture;
import org.parking.gestio_parking.entities.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FactureMppers {
    public Facture fromFactureDto(FactureDto factureDto){
        Facture facture = new Facture();
        BeanUtils.copyProperties(factureDto,facture);
        if(factureDto.getReservationID()!=0){
            Reservation reservation = new Reservation();
            reservation.setId_Reservation(factureDto.getReservationID());
            facture.setReservation(reservation);
        }
        return facture;
    }
    public FactureDto fromFacture(Facture facture){
        FactureDto factureDto=new FactureDto();
        BeanUtils.copyProperties(facture,factureDto);
        if (facture.getReservation()!=null){
            factureDto.setReservationID(facture.getReservation().getId_Reservation());
        }
        return factureDto;
    }
}

package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.ReservationDto;
import org.parking.gestio_parking.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ReservationMappers {
    public Reservation fromReservationDto (ReservationDto reservationDto){
        Reservation reservation=new Reservation();
        BeanUtils.copyProperties(reservationDto,reservation);
        if(reservationDto.getClientId()!=0 || reservationDto.getPlaceId()!=0 || reservationDto.getVehiculeId()!=0){
            Client client = new Client();
            client.setIdClient(reservationDto.getClientId());
            reservation.setClient(client);
            Place place = new Place();
            place.setId_Place(reservationDto.getPlaceId());
            reservation.setPlace(place);
            Vehicule vehicule = new Vehicule();
            vehicule.setId_vehicule(reservationDto.getVehiculeId());
            reservation.setVehicule(vehicule);

        }
        return reservation;
    }
    public ReservationDto fromReservation (Reservation reservation){
        ReservationDto reservationDto=new ReservationDto();
        BeanUtils.copyProperties(reservation,reservationDto);
        if (reservation.getClient() != null|reservation.getPlace()!=null|reservation.getVehicule()!=null) {
            reservationDto.setPlaceId(reservation.getPlace().getId_Place());
            reservationDto.setClientId(reservation.getClient().getIdClient());
            reservationDto.setVehiculeId(reservation.getVehicule().getId_vehicule());


        }
        return reservationDto;
    }
}

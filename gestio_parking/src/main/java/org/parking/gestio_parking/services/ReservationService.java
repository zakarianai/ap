package org.parking.gestio_parking.services;

import org.parking.gestio_parking.Dto.ReservationDto;
import org.parking.gestio_parking.Exceptions.ExceptionResrvationNotFound;

import java.util.List;

public interface ReservationService {
    ReservationDto saveresrvation(ReservationDto reservationDto);
    List<ReservationDto> listeReservation();
    ReservationDto resrvationById(int id ) throws ExceptionResrvationNotFound;
    ReservationDto updateResrvation(int id ,ReservationDto reservationDto) throws ExceptionResrvationNotFound;
    void deleteResrvation(int id);
}

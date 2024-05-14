package org.parking.gestio_parking.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.Dto.ReservationDto;
import org.parking.gestio_parking.Exceptions.ExceptionResrvationNotFound;
import org.parking.gestio_parking.entities.Reservation;
import org.parking.gestio_parking.mappers.ReservationMappers;
import org.parking.gestio_parking.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class ResrvationserviceImpl implements ReservationService{
    @Autowired
    private ReservationMappers reservationMappers;
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public ReservationDto saveresrvation(ReservationDto reservationDto) {
        Reservation reservation = reservationMappers.fromReservationDto(reservationDto);
        reservationRepository.save(reservation);

        return reservationMappers.fromReservation(reservation);
    }

    @Override
    public List<ReservationDto> listeReservation() {
        List<Reservation> listeResrvation = reservationRepository.findAll();
        List<ReservationDto> list = listeResrvation.stream().map(res->reservationMappers.fromReservation(res)).collect(Collectors.toList());
        return list;
    }

    @Override
    public ReservationDto resrvationById(int id) throws ExceptionResrvationNotFound {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()-> new ExceptionResrvationNotFound("Resvation not found"));
        return reservationMappers.fromReservation(reservation);
    }

    @Override
    public ReservationDto updateResrvation(int id, ReservationDto reservationDto) throws ExceptionResrvationNotFound {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()-> new ExceptionResrvationNotFound("Resvation not found"));
        Reservation newresrvation = reservationMappers.fromReservationDto(reservationDto);
        reservation.setDate_entree(newresrvation.getDate_entree());
        reservation.setDate_retour(newresrvation.getDate_retour());
        return reservationMappers.fromReservation(reservation);
    }

    @Override
    public void deleteResrvation(int id) {
        reservationRepository.deleteById(id);


    }
}

package org.parking.gestio_parking.web;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.ReservationDto;
import org.parking.gestio_parking.Exceptions.ExceptionResrvationNotFound;
import org.parking.gestio_parking.entities.Reservation;
import org.parking.gestio_parking.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ReservationRestController {
    public ReservationService reservationService;
    @GetMapping("/resvations")
    public List<ReservationDto> listresrvation(){return reservationService.listeReservation();}
    @GetMapping("/reservation/{id}")
    public ReservationDto getresrvation(@PathVariable int id ) throws ExceptionResrvationNotFound {
        return reservationService.resrvationById(id);
    }
    @PostMapping("/reservation")
    public ReservationDto savereservation (@RequestBody  ReservationDto reservation){
        return reservationService.saveresrvation(reservation);

    }
    @DeleteMapping("/reservation/{id}")
    public void deleteresrvation (@PathVariable int id ){
        reservationService.deleteResrvation(id);
    }
    @PutMapping("/resrvation")
    public ReservationDto updateresvation (@PathVariable int id , @RequestBody ReservationDto reservationDto) throws ExceptionResrvationNotFound {
        return reservationService.updateResrvation(id,reservationDto);
    }

}

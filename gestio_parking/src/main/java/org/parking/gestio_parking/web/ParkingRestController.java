package org.parking.gestio_parking.web;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.ParkingDto;
import org.parking.gestio_parking.Exceptions.ExceptionParkingNotFound;
import org.parking.gestio_parking.services.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ParkingRestController {
    private ParkingService parkingService;
    @GetMapping("/parkings")
    public List<ParkingDto> parkingDtoList(){
        return parkingService.listeparking();
    }
    @GetMapping("/parking/{id}")
    public ParkingDto getParkingById(@PathVariable int id) throws ExceptionParkingNotFound {
        return parkingService.park(id);
    }
    @PostMapping("/parking")
    public ParkingDto saveParking(@RequestBody ParkingDto parkingDto){
        return parkingService.SaveParking(parkingDto);
    }
    @PutMapping("/parking/{id}")
    public ParkingDto updateParking(@PathVariable int id ,@RequestBody ParkingDto parkingDto) throws ExceptionParkingNotFound {
        return parkingService.UpdateParking(id,parkingDto);
    }
    @DeleteMapping("/parking/{id}")
    public void deleteParking(@PathVariable int id){
        parkingService.DeleteParking(id);
    }
}

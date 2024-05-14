package org.parking.gestio_parking.web;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.PlaceDto;
import org.parking.gestio_parking.Exceptions.ExceptionPlaceNotFoud;
import org.parking.gestio_parking.services.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PlaceRestController {
    private PlaceService placeService;
    @GetMapping("/places")
    public List<PlaceDto> listPlaces (){
        return placeService.listePlace();
    }
    @GetMapping("/place/{id}")
    public PlaceDto getPlaceById(@PathVariable int id) throws ExceptionPlaceNotFoud {
        return placeService.placeById(id);
    }
    @PostMapping("/place")
    public PlaceDto savePlace(PlaceDto placeDto){
        return placeService.SavePlace(placeDto);
    }
    @PutMapping("/place/{id}")
    public PlaceDto updatePlace(@PathVariable int id ,@RequestBody PlaceDto placeDto) throws ExceptionPlaceNotFoud {
        return placeService.Updateplace(id, placeDto);
    }
    @DeleteMapping("/place/{id}")
    public void deletePlace(@PathVariable int id){
        placeService.Delete(id);
    }
}
